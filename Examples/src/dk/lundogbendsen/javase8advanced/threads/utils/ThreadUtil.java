/*
 * Hjælpeklasse, der kan bruges til at få bedre overblik over
 * tråde i Java. Specielt er følgende metoder værd at bruge:
 * <BR>
 * ThreadUtil.printThreadNames( ), der ændrer System.out til
 * at indsætte navnet på tråden der udskriver foran det, der
 * udskrives.
 * <BR>
 * ThreadUtil.showInvestigator( ), der frembringer et grafisk
 * vindue, hvor man kan se hvordan tråd-situationen har været
 * på alle de tidspunkter hvor den tilhørende metode kaldet
 * ThreadUtil.makeSnapshot( String snapshotName ) er blevet
 * kaldt. Dvs. kald showInvestigator først, og herefter
 * makeSnapshot alle de steder i din kode, hvor du efterfølgende
 * kunne tænke dig at vide hvordan trådsituationen så ud.
 * <BR>
 * For eksempler på brugen af ThreadUtil se:
 * WhoIsDoingWhatEx02.java og
 * UnderstandingThreadGroupsEx02.java
 */
package dk.lundogbendsen.javase8advanced.threads.utils;

public class ThreadUtil {
	static private boolean investigatorIsShowing = false;

	public static void printThreadNames() {
		System.setOut(new PrintStreamShowingThreadNames(System.out, true));
	}

	public static void showInvestigator() {
		if (investigatorIsShowing == false) {
			Investigator.show();
			investigatorIsShowing = true;
		}
	}

	public static void makeSnapshot(final String snapshotName) {
		if (investigatorIsShowing == true) {
			Investigator.makeSnapshot(snapshotName);
		} else {
			String msg = "Code must call ThreadUtil.showInvestigator( )";
			msg += ", before any calls to ThreadUtil.makeSnapshot";
			msg += "( String snapshotName ) can be made";
			throw new IllegalStateException(msg);
		}
	}

	static public ThreadGroup getRootThreadGroup() {
		Thread thread = Thread.currentThread();
		ThreadGroup group = thread.getThreadGroup();
		while (group.getParent() != null) {
			group = group.getParent();
		}
		return group;
	}

	static public Thread[] getCurrentThreads() {
		ThreadGroup root = getRootThreadGroup();
		int numberOfThreads = root.activeCount();
		Thread[] childThreads = new Thread[numberOfThreads];
		root.enumerate(childThreads, true);
		int notNullsInChildThreads = 0;
		for (int n = 0; n < childThreads.length; n++) {
			if (childThreads[n] != null) {
				notNullsInChildThreads++;
			}
		}
		Thread[] compactedArray = new Thread[notNullsInChildThreads];
		for (int n = 0; n < notNullsInChildThreads; n++) {
			compactedArray[n] = childThreads[n];
		}
		return compactedArray;
	}

	static public ThreadGroup[] getCurrentThreadGroups() {
		ThreadGroup root = getRootThreadGroup();
		// antal sub-grupper + 1 for root-gruppen selv
		int numberOfThreadGroups = root.activeGroupCount() + 1;
		ThreadGroup[] threadGroups = new ThreadGroup[numberOfThreadGroups];
		root.enumerate(threadGroups, true);
		for (int n = (threadGroups.length - 1); n > 0; n--) {
			threadGroups[n] = threadGroups[n - 1];
		}
		threadGroups[0] = root;
		int notNullsInThreadGroups = 0;
		for (int n = 0; n < threadGroups.length; n++) {
			if (threadGroups[n] != null) {
				notNullsInThreadGroups++;
			}
		}
		ThreadGroup[] compactedArray = new ThreadGroup[notNullsInThreadGroups];
		for (int n = 0; n < notNullsInThreadGroups; n++) {
			compactedArray[n] = threadGroups[n];
		}
		return compactedArray;
	}

	public static void main(final String[] args) {
		ThreadUtil.showInvestigator();
		new Thread("R-1") {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
					}
				}
			}
		}.start();
		ThreadUtil.makeSnapshot("Made thread R-1");
		ThreadGroup group = new ThreadGroup("R-2");
		ThreadUtil.makeSnapshot("Made group R-2");
		Thread t = new Thread(group, "R-3") {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
					}
				}
			}
		};
		t.start();
		ThreadUtil.makeSnapshot("Made thread R-3");
		Thread t2 = new Thread(group, "R-4") {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
					}
				}
			}
		};
		t2.setDaemon(true);
		t2.start();
		t2.setPriority(3);
		ThreadUtil.makeSnapshot("Made thread R-4");
		t2.setPriority(4);
		ThreadUtil.makeSnapshot("Set priority of R-4");
	}
}

package dk.lundogbendsen.javase8advanced.threads.utils;

/** **************************************************************** */
// PRINTSTREAMSHOWINGTHREADNAMES ENDS HERE
/** **************************************************************** */
/** **************************************************************** */
// INVESTIGATOR BEGINS HERE
/** **************************************************************** */
/*
 * Investigator is a simple Facade to the ThreadInvestigator, and furthermore
 * Investigator acts as single point of entry to the ThreadInvestigator, only
 * giving access to one Thread at a time
 */
public class Investigator
{
  synchronized static void makeSnapshot(final String name)
  {
    Model.getModel().makeSnapshot(name);
  }

  synchronized static void show()
  {
    View.getView();
  }
}
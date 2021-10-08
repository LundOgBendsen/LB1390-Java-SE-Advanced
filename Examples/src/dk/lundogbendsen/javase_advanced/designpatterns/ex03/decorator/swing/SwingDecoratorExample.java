package dk.lundogbendsen.javase_advanced.designpatterns.ex03.decorator.swing;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SwingDecoratorExample {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTextArea textArea = new JTextArea();
		textArea.setText(
				"alsdæjfls adkjfljlsajdf \nljsfldjlsdjflk jsdlfkj\nsldfj lksdfj lksj dlfkj\nslkdfj lksd jlfk jsldkf jlksd jfl\nsldf jlsd flk alskdf lkajs\nflkjasdfljk asdfklæsadj flæskadlk jasdlf jsdfkl æja skfd j\nlæksjdflkæajl slkadfj æsaldfj\naskldfj  lkj ælj k\nlkj sdafælkj lsdækf\n jlksæfad jæfkjfl \nlksdj fæ lkæj æ jlæ læk jælkj \nflæaksj dflæasj dflkj sdf a\naklsdjf lækj slækfj æasdfælkj\nlæsdkafjslaædf lkj sadfljj a\naskldf jklæjs adflækja sdf\nlækj asdflkj alæsdfæjl kaælsdf\nasdfklj klj asdflæk \nj lkæas jdflæjk asdfælkj asdfælkj\nas flækj ljkæsadfælkj asdf\n ælkasdfjk lsadflækj asdfælkj\nlkæajs lækj asdflæk jlækjasd\nælksjadflækj asdfælkj afælkj\n");

		// Decorate the text area with scroll panes
		JScrollPane scrollPane = new JScrollPane(textArea);

		frame.add(scrollPane);
		frame.setSize(200, 200);
		frame.setVisible(true);
	}
}

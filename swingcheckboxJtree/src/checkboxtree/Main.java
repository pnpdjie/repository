package checkboxtree;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

/**
 * checkboxtree demo
 *
 */
public class Main {
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("CheckBoxTreeDemo");
		frame.setBounds(200, 200, 400, 400);
		JTree tree = new JTree();
		CheckBoxTreeNode rootNode = new CheckBoxTreeNode("User Guides");
		CheckBoxTreeNode node1 = new CheckBoxTreeNode(new NodeObj("Markdown","/docs/xx/xx.md"));
		CheckBoxTreeNode node1_1 = new CheckBoxTreeNode(new NodeObj("图片添加热点","/docs/xx/图片添加热点.md"));
		CheckBoxTreeNode node1_2 = new CheckBoxTreeNode(new NodeObj("表格引用","/docs/xx.md"));
		CheckBoxTreeNode node1_3 = new CheckBoxTreeNode(new NodeObj("引用图片方式","/docs/xx2.md"));
		node1.add(node1_1);
		node1.add(node1_2);
		node1.add(node1_3);
		CheckBoxTreeNode node2 = new CheckBoxTreeNode("Simple Workflow");
		CheckBoxTreeNode node2_1 = new CheckBoxTreeNode(new NodeObj("Sample1","/docs/xx2.md"));
		CheckBoxTreeNode node2_2 = new CheckBoxTreeNode(new NodeObj("Sample2","/docs/xx2.md"));
		node2.add(node2_1);
		node2.add(node2_2);
		rootNode.add(node1);
		rootNode.add(node2);
		DefaultTreeModel model = new DefaultTreeModel(rootNode);
		tree.addMouseListener(new CheckBoxTreeNodeSelectionListener());
		tree.setModel(model);
		tree.setCellRenderer(new CheckBoxTreeCellRenderer());
		JScrollPane scroll = new JScrollPane(tree);
		scroll.setBounds(0, 0, 300, 320);
		//show select info
		JButton btnPdf = new JButton("pdf");
		btnPdf.addMouseListener(new GetSelectedInfo());
		
		frame.getContentPane().add(btnPdf, BorderLayout.SOUTH);
		frame.getContentPane().add(scroll);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}

 

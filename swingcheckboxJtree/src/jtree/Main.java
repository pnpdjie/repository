package jtree;


import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JButton;
import java.awt.BorderLayout;
 
/**
 * ����jtree
 * ������checkboxtree���µ���
 * @author jiewangz
 *
 */
public class Main {
    public static void main(String[] args) {
 
        // ����û�и��ڵ���ӽڵ㡢���������ӽڵ�����ڵ㣬��ʹ��ָ�����û�����������г�ʼ����
        // public DefaultMutableTreeNode(Object userObject)
        DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("Markdown");
        node1.add(new DefaultMutableTreeNode(new User("ͼƬ����ȵ�")));
        node1.add(new DefaultMutableTreeNode(new User("�������")));
        node1.add(new DefaultMutableTreeNode(new User("����ͼƬ��ʽ")));
 
        DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("Simple Workflow");
        node2.add(new DefaultMutableTreeNode(new User("Sample1")));
        node2.add(new DefaultMutableTreeNode(new User("Sample2")));
        node2.add(new DefaultMutableTreeNode(new User("Sample3")));
 
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("User Guides");
 
        top.add(new DefaultMutableTreeNode(new User("Markdown�﷨���")));
        top.add(node1);
        top.add(node2);
        final JTree tree = new JTree(top);
        JFrame f = new JFrame("JTreeDemo");
        f.getContentPane().add(tree);
        
        JButton btnPdf = new JButton("pdf");
        f.getContentPane().add(btnPdf, BorderLayout.SOUTH);
        f.setSize(300, 300);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // ���ѡ���¼�
        tree.addTreeSelectionListener(new TreeSelectionListener() {
 
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree
                        .getLastSelectedPathComponent();
 
                if (node == null)
                    return;
 
                Object object = node.getUserObject();
                if (node.isLeaf()) {
                    User user = (User) object;
                    System.out.println("��ѡ���ˣ�" + user.toString());
                }
 
            }
        });
    }
}
 
class User {
    private String name;
    private String path;
    public User(String n) {
        name = n;
    }
 
    // �ص���toString���ڵ����ʾ�ı�����toString
    public String toString() {
        return name;
    }
}
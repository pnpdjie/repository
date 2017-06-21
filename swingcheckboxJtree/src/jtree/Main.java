package jtree;


import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JButton;
import java.awt.BorderLayout;
 
/**
 * 基础jtree
 * 不依赖checkboxtree包下的类
 * @author jiewangz
 *
 */
public class Main {
    public static void main(String[] args) {
 
        // 创建没有父节点和子节点、但允许有子节点的树节点，并使用指定的用户对象对它进行初始化。
        // public DefaultMutableTreeNode(Object userObject)
        DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("Markdown");
        node1.add(new DefaultMutableTreeNode(new User("图片添加热点")));
        node1.add(new DefaultMutableTreeNode(new User("表格引用")));
        node1.add(new DefaultMutableTreeNode(new User("引用图片方式")));
 
        DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("Simple Workflow");
        node2.add(new DefaultMutableTreeNode(new User("Sample1")));
        node2.add(new DefaultMutableTreeNode(new User("Sample2")));
        node2.add(new DefaultMutableTreeNode(new User("Sample3")));
 
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("User Guides");
 
        top.add(new DefaultMutableTreeNode(new User("Markdown语法解读")));
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
        // 添加选择事件
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
                    System.out.println("你选择了：" + user.toString());
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
 
    // 重点在toString，节点的显示文本就是toString
    public String toString() {
        return name;
    }
}
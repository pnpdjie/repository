package checkboxtree;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JTree;
import javax.swing.tree.TreePath;
import javax.swing.tree.DefaultTreeModel;

/**
 * 添加一个响应用户鼠标事件的监听器
 *
 */
public class CheckBoxTreeNodeSelectionListener extends MouseAdapter {
	List<NodeObj> list = new ArrayList();

	@Override
	public void mouseClicked(MouseEvent event) {
		JTree tree = (JTree) event.getSource();
		int x = event.getX();
		int y = event.getY();
		int row = tree.getRowForLocation(x, y);
		TreePath path = tree.getPathForRow(row);
		if (path != null) {
			CheckBoxTreeNode node = (CheckBoxTreeNode) path.getLastPathComponent();
			if (node != null) {
				boolean isSelected = !node.isSelected();
				node.setSelected(isSelected);
				((DefaultTreeModel) tree.getModel()).nodeStructureChanged(node);

				Object[] nodeObj = node.getUserObjectPath();
				try {
					NodeObj n = (NodeObj) nodeObj[nodeObj.length - 1];
					if (!list.contains(n))
						list.add(n);
					show(list);
					// System.out.println(n.getName() + "-" + n.getPath() + "--"
					// + isSelected);
				} catch (Exception e) {
					System.err.println(node + " 无对应路径");
				}

			}
		}
	}

	private void show(List<NodeObj> l) {
		System.out.println("--------------list-----------------");
		for(NodeObj o:l){
			System.out.print("<"+o.getName()+","+o.getPath()+">");
		}
		System.out.println();
		
	}
}
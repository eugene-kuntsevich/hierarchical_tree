import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main
{
	private static StringBuilder builder = new StringBuilder();

	public static void main(String[] args)
	{
		Node node1 = new Node(1L, null);
		Node node2 = new Node(2L, node1);
		Node node3 = new Node(3L, node1);
		Node node4 = new Node(4L, node2);
		Node node5 = new Node(5L, node3);
		Node node6 = new Node(6L, node5);

		List<Node> inputNodes = new ArrayList<>(Arrays.asList(node1, node2, node3, node4, node5, node6));

		List<Node> nodes = HierarchicBuilder.buildNodesHierarchic(inputNodes);

		printNodesHierarchy(nodes);
	}

	private static void printNodesHierarchy(List<Node> nodes)
	{
		for (Node node : nodes)
		{
			if (node.getParentNode() == null)
			{
				System.out.println(node.toString() + " -> no parent");
				if (!node.getChildrenNodes().isEmpty())
				{
					printNodesHierarchy(node.getChildrenNodes());
				}
			}
			else
			{
				printNodeWithAllParentNodes(node);
				System.out.println(builder.toString());
				builder = new StringBuilder();
				if (!node.getChildrenNodes().isEmpty())
				{
					printNodesHierarchy(node.getChildrenNodes());
				}
			}
		}
	}

	private static void printNodeWithAllParentNodes(Node node)
	{
		if ("".equals(builder.toString()))
		{
			builder.append(node.toString());
		}
		builder.append(" -> " + node.getParentNode().toString());
		if (node.getParentNode().getParentNode() != null)
		{
			printNodeWithAllParentNodes(node.getParentNode());
		}
	}
}

import java.util.List;
import java.util.Objects;

public class HierarchicBuilder
{
	public static List<Node> buildNodesHierarchic(List<Node> inputNodes)
	{
		for (Node node : inputNodes)
		{
			if (node.getParentNode() != null)
			{
				addChildToParent(inputNodes, node);
			}
		}
		removeChildrenFromCollection(inputNodes);
		return inputNodes;
	}

	private static void addChildToParent(List<Node> inputNodes, Node child)
	{
		for (Node parent : inputNodes)
		{
			if (Objects.equals(parent.getId(), child.getParentId()))
			{
				addChildIfNotAddedBefore(child, parent);
				return;
			}
			if (!parent.getChildrenNodes().isEmpty())
			{
				addChildToParent(parent.getChildrenNodes(), child);
			}
		}
	}

	private static void addChildIfNotAddedBefore(Node child, Node parent)
	{
		if (!parent.getChildrenNodes().contains(child))
		{
			parent.getChildrenNodes().add(child);
		}
	}

	private static void removeChildrenFromCollection(List<Node> inputNodes)
	{
		inputNodes.removeIf(node -> node.getParentNode() != null);
	}
}

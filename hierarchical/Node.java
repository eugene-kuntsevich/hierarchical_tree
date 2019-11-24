import java.util.ArrayList;
import java.util.List;

public class Node
{
	private Long id;
	private Node parentNode;
	private List<Node> childrenNodes = new ArrayList<>();

	public Node(Long id, Node parentNode)
	{
		this.id = id;
		this.parentNode = parentNode;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Node getParentNode()
	{
		return parentNode;
	}

	public void setParentNode(Node parentNode)
	{
		this.parentNode = parentNode;
	}

	public List<Node> getChildrenNodes()
	{
		return childrenNodes;
	}

	public void setChildrenNodes(List<Node> childrenNodes)
	{
		this.childrenNodes = childrenNodes;
	}

	public Long getParentId()
	{
		return parentNode.getId();
	}

	@Override
	public String toString()
	{
		return "Node(id=" + id + ")";
	}
}

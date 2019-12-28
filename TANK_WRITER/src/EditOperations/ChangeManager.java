package EditOperations;

public class ChangeManager {

	// the current index node
	private Node currentIndex = null;
	// the parent node far left node
	private Node parentNode = new Node();

	// creates a changeManager object which is initially empty
	public ChangeManager() {
		currentIndex = parentNode;
	}

	// creates a new changeManager which is a duplicate of the parameter in both
	/*public ChangeManager(ChangeManger manager) {
		this();
		currentIndex = manager.currentIndex;
	}*/

	// clears all changeables contained in this manager
	public void addChangeable(Changeable changeable) {
		Node node = new Node(changeable);
		currentIndex.right = node;
		node.left = currentIndex;
		currentIndex = node;
	}

	// determines if an undo can be performed
	public boolean canUndo() {
		return currentIndex != parentNode;
	}

	public boolean canRedo() {
		return currentIndex.right != null;
	}

	public void undo() {
		// validate
		if (!canUndo()) {
			throw new IllegalStateException("Cannot undo. Index is out of range");
		}

		// undo
		currentIndex.changeable.undo();
		// set index
		moveLeft();
	}
	
	public void redo() {
		// validate
		if (!canRedo()) {
			throw new IllegalStateException("Cannot redo. Index is out of range");
		}

		// reset index
		moveRight();
		// redo
		currentIndex.changeable.redo();
	}


	// Moves the internal pointer of the backed linked list to the left
	// @throws illegalstateException if the right index is null
	private void moveLeft() {
		if (currentIndex.left == null) {
			throw new IllegalStateException("Internal index set to null");
		}
		currentIndex = currentIndex.left;
	}

	// Moves the internal pointer of the backed linked list to the left
	// @throws illegalstateException if the right index is null
	private void moveRight() {
		if(currentIndex.right == null) {
			throw new IllegalStateException("Internal index set to null");
		}
		currentIndex = currentIndex.right;
	}

	
	// Inner class to implement a doubly linked lsit for our queue of Changeables
	public class Node {
		private Node left = null;
		private Node right = null;

		private final Changeable changeable;

		public Node(Changeable c) {
			changeable = c;
		}

		public Node() {
			changeable = null;
		}
	}

}

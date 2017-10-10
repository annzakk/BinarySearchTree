package ExcersicesinClass;

public class BinarySearchTree {
	public static Node root;
	public BinarySearchTree(){
		BinarySearchTree.root = null;
	}
	
	// add  function or add
	public void add(int id){
		Node newNode = new Node(id);
		if(root== null){
			root = newNode;
					return;
		}
		Node current = root;
		Node parent = null;
		while(true){
			parent = current;
			if(id<current.data){				
				current = current.left;
				if(current==null){
					parent.left = newNode;
					return;
				}
			}else{
				current = current.right;
				if(current==null){
					parent.right = newNode;
					return;
				}
	}
		}}
	
	public boolean find(int id){
		Node current = root;
		while(current!=null){
			if(current.data==id){
				return true;
			}
			else if(current.data>id){
				current = current.left;				
			}
			else{
				current = current.right;
			}		
		}

		return false;
	}
	
	public boolean delete(int id){
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false;
		while(current.data!=id){
			parent = current;
			if(current.data>id){
				isLeftChild = true;
				current = current.left;
			}else{
				isLeftChild = false;
				current = current.right;
			}
			if(current ==null){
				return false;
			}
	} // if we are here then it means we have found the node. // but the note to be deleted may or may not have children
		//if it does not have children
		if(current.left==null && current.right==null){
			if(current==root){
				root = null;
			}
			if(isLeftChild ==true){
				parent.left = null;
			}else{
				parent.right = null;
			}
		}
		//another case is if the node that is going to be deleted has a child
		else if(current.right==null){
			if(current==root){
				root = current.left;
			}else if(isLeftChild){
				parent.left = current.left;
			}else{
				parent.right = current.left;
			}
		}
		else if(current.left==null){
			if(current==root){
				root = current.right;
			}else if(isLeftChild){
				parent.left = current.right;
			}else{
				parent.right = current.right;
			}
		}else if(current.left!=null && current.right!=null){
			
			//at this point we have the min element in the right tree
			//do a heritor so we now which is the highest element
			Node heritor	 = getHeritor(current);
			if(current==root){
				root = heritor;
			}else if(isLeftChild){
				parent.left = heritor;
			}else{
				parent.right = heritor;
			}			
			heritor.left = current.left;
		}		
		return true;		
	}
	//to get the heritor and delete it if it is the right child
	public Node getHeritor(Node deleleNode){
		Node heritor =null;
		Node heritorParent =null;
		Node current = deleleNode.right;
		while(current!=null){ //checks if hertior have the right child
			heritorParent = heritor; //if it does not have the right child
			heritor = current;  
			current = current.left;
		}if(heritor!=deleleNode.right){ //add left of heritorParent
			heritorParent.left = heritor.right;
			heritor.right = deleleNode.right;
		}
		return heritor;
	}
	public void display(Node root){  //for the display in main
		if(root!=null){
			display(root.left);
			System.out.print(" " + root.data);
			display(root.right);
		}
	}
	public static void main(String arg[]){
		BinarySearchTree b = new BinarySearchTree();
		b.add(3);b.add(8);
		b.add(1);b.add(4);b.add(6);b.add(2);b.add(10);b.add(9);
		b.add(20);b.add(25);b.add(15);b.add(16);
		System.out.println("Tree from beginning with binarySearch : ");
		b.display(b.root);		
		System.out.println("");
		System.out.println("Check whether Node with value 5 exists : " + b.find(5));
		System.out.println("Delete Node with no children (2) : " + b.delete(2));		
		b.display(root);
		System.out.println("\n Delete Node with one child (4) : " + b.delete(4));		
		b.display(root);
		System.out.println("\n Delete Node with Two children (10) : " + b.delete(10));		
		b.display(root);
	}
}

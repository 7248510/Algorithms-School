import java.util.*;
    public class BinaryTree 
    {
        TreeNode root;
        public BinaryTree() {
            root = null;
        }
        public boolean insert(Listing newListing) 
        {   
            TreeNodeWrapper parent = new TreeNodeWrapper(); //Spawning the parent
            TreeNodeWrapper child = new TreeNodeWrapper(); //Spawning the child
            TreeNode currentTree = new TreeNode();
            if (currentTree == null) { //Checking if the currentTree is out of memory.
                return false;
            }
            else { //Insert the node since the tree is not out of memory
                currentTree.node = newListing.deepCopy(); //Getting the fields
                currentTree.lc = null; //Setting the left branch to null
                currentTree.rc = null; //Setting the right branch to null
                if (root == null) {  //The tree is empty. Same as teh previous if statement except we're comparing the root
                    root = currentTree; //Setting the root to the currentTree which would be empty in this case
                }
                else {
                    findNode(newListing.getKey(), parent, child); //Looking for the current nodes parent. This is where the getKey method is first utilized.
                    if (newListing.getKey().compareTo(parent.get().node.getKey()) < 0) { //Comparing the parent's value node value. Checking if it is less than 0
                        parent.get().lc = currentTree; //If it is insert the node into the left branch/child.
                    }
                    else {
                        parent.get().rc = currentTree; //If not insert the node to the right branch/child.
                    }
                    return true; //Return true since the function didn't have an error
                }
            return true; //Returning true again because the function succesfully executed.
            }
        }
        public Listing fetch(String targetKey)
        {
            boolean found; //This is the same as the delete function. Its purpose is to set T or F if the called node is found.
            TreeNodeWrapper parent = new TreeNodeWrapper(); //Spawning the parent
            TreeNodeWrapper child = new TreeNodeWrapper(); //Spawning the child
            found = findNode(targetKey, parent, child); //Finding the node
            if (found == true) {
                return child.get().node.deepCopy(); //Return the current node. It gets the child node and then the node class is called and a deep copy is made.
            }
            else {
                return null; //The console will display null.
        }
    }
        public boolean delete(String targetKey)
        {
            boolean found; //This is the same as the fetch function. Its purpose is to get the targetKey and delete it
            TreeNodeWrapper parent = new TreeNodeWrapper(); //Spawning the parent
            TreeNodeWrapper child = new TreeNodeWrapper(); //Spawning the child
            TreeNode currentLargest; //Used to compare the branches
            TreeNode nextLargest; //The next largest value
            found = findNode(targetKey, parent, child); //Finding the node 
            if (found == false) {
                return false; //You cannot delete if you don't have the node. Returns false and the operation does not continue any further.
            }
            else { //The found must evaluate to true if its not false
                if(child.get().lc == null && child.get().rc == null) //Checking if the node has no children. It first checks that the left node is equal to null and the right child is also null
                    { 
                        if(parent.get().lc == child.get()) { //If the left node is a left child. It checks the contents
                            parent.get().lc = null; //
                        }
                    else {    
                    parent.get().rc = null; //Then the node must be a right child. At this point you don't need to check the node since you're already at this step.
                }
            }
            else if(child.get().lc == null || child.get().rc == null) //The node has at least one child.
            { 
                if(parent.get().lc == child.get()) //Checking if the node has a left child
                { 
                    if(child.get().lc != null) { //If the left node is populated
                    parent.get().lc = child.get().lc; //delete the node
                    }
                    else    //It must be a right node  
                        parent.get().lc = child.get().rc;  //Deleting the right node
                }
            }
            else //The current node has two children
            {
                nextLargest = child.get().lc; //Getting the left child/setting the nextlargest to the left child
                currentLargest = nextLargest.rc; //Setting the current value/largest to the nextLargest right child.
                if(currentLargest != null) //We already know its not null.
                {
                    while(currentLargest.rc != null) //Sets the nextLarget to the largest node
                    {
                        nextLargest = currentLargest;
                        currentLargest = currentLargest.rc; //Setting the currentLargest to the largest right child.
                    }
                    child.get().node = currentLargest.node; //Overwritting the deleted node
                    nextLargest.rc = currentLargest.lc; //Saving the node to the left tree
                }
                else //The left child does not have a right tree
                {
                    nextLargest.rc = child.get().rc; //Save the right tree
                    if(parent.get().lc == child.get()) { //If the node is a left child
                        parent.get().lc = nextLargest; //Set the parent left child as the next largest node
                    }
                    else {
                        parent.get().rc = nextLargest; //Skips the node
                    }
                }
            }
            return true;
            }
        }
        public boolean update(String targetKey, Listing newListing)
        {
            if(delete(targetKey) == false) //You can't update what you don't have
                return false;
            else if(insert(newListing) == false) //Insert the new listing
                return false; //This will return false if the newListing is not valid/your update failed
            return true; //The node has been updates
        }
        public class TreeNode {
            private Listing node; //This is like previous problems.(Structure wise)
            private TreeNode lc;  //Getting the left child/declaring
            private TreeNode rc; //Getting the right child/declaring
        }
    private boolean findNode(String targetKey, TreeNodeWrapper parent, TreeNodeWrapper child)
    {
        parent.set(root); //Setting the parent node as well as the child node to root
        child.set(root);
        if(root == null) {//The tree is empty you cannot do anything 
            return true;
        }
        while(child.get() != null) { //If it passes the above condition
            if(child.get().node.compareTo(targetKey) == 0) {
                return true; //The node has been found. Returns a true value 
            }
            else{
                parent.set(child.get());
                if(targetKey.compareTo(child.get().node.getKey()) < 0)
                    child.set(child.get().lc); //Setting the child to the left child branch
                else    
                    child.set(child.get().rc); //Setting the child to the right child branch
            }
        }
        return false;
    }
    public void LNRoutputTraversal(TreeNode root)
    {
        if (root.lc != null) //Implementing recursion
            LNRoutputTraversal(root.lc);
        System.out.println(root.node);
        if(root.rc != null)
            LNRoutputTraversal(root.rc);
    }
    public void showAll() {
        if(root == null)
            System.out.println("Empty");
        else
            LNRoutputTraversal(root); //Recursion. Keep calling itself until the branches have been traversed.
    }
    public void RNLoutputTraversal(TreeNode root) //Traversing the right branch. This results in decending order
    {
        if (root.rc != null)
            RNLoutputTraversal(root.rc);
        System.out.println(root.node);
        if(root.lc != null)
            RNLoutputTraversal(root.lc);
    }
    public void descending() { //Exactly the same as show all
        if(root == null)
            System.out.println("Empty");
        else
            RNLoutputTraversal(root);
    }

    public class TreeNodeWrapper{
        TreeNode treeRef = null; //Setting treeref to null be default
        public TreeNode get()
        {
            return treeRef; //Once the function is called return to tree ref
        }
        public void set(TreeNode currentTree)
        {
            treeRef = currentTree; //Setting the referred value to the current value
        }
    }
    public void choice()
        {
            BinaryTree choiceInput = new BinaryTree();
            String message = "Press 1 to insert a new students information:\nPress 2 to fetch and output a students information\nPress 3 to delete a students information\nPress 4 to update a students information\nPress 5 to output all the students information\npress 6 to exit";
            System.out.println(message);
            Scanner myObj = new Scanner(System.in);
            int catalyst = myObj.nextInt();
            Listing julia = new Listing("Julia", "234", "4.00");
            Listing johnny = new Listing("Johnny", "857", "3.00");
            Listing chuck = new Listing("Chuck", "007", "4.01");
            Listing Suzan = new Listing("Suzan", "344", "4.00");
            Listing updatedValue = new Listing("Updated Name", "1234", "3.00");
            choiceInput.insert(johnny);
            choiceInput.insert(chuck);
            choiceInput.insert(julia);
            if  (catalyst == 1) {
                System.out.println("Please input the name:");
                String localName = myObj.next();
                System.out.println("Please input the students ID:");
                String localID = myObj.next();
                System.out.println("Please input the students GPA:");
                String localGPA = myObj.next();
                Listing inputMe = new Listing(localName, localID, localGPA);
                choiceInput.insert(inputMe);
                choiceInput.showAll();
            }
            if (catalyst == 2) {
                System.out.println("Please select a students information to fetch.\nUse the first name in the operatiocurrentTree\nOutputting the students to fetch.");
                choiceInput.showAll();
                System.out.println("Please input the name(first name) you'd like to fetch:");
                String fetchMe = myObj.next();
                System.out.println("Fetching " + fetchMe);
                System.out.println(choiceInput.fetch(fetchMe));
            }
            if  (catalyst == 3) {
                System.out.println("Outputting names that can be deleted. Please use the first name to delete.");
                choiceInput.showAll();
                String deleteMe = myObj.next();
                System.out.println(choiceInput.delete(deleteMe));
                System.out.println("Printing the current names");
                choiceInput.showAll();
            }
            if  (catalyst == 4) {
                choiceInput.showAll();
                System.out.println("Please enter the name you'd like to update.\nThe default value for the update is\nName: Updated Name, ID 1234, GPA 3.00\nUpdating Johnny.");
                choiceInput.update("Johnny", updatedValue);
                choiceInput.showAll();
            }
            if  (catalyst == 5) {
                System.out.println("Outputting the names in descending order.");
                choiceInput.descending();
            }
            if  (catalyst == 6) {
            System.exit(0);
            }
        }
    }
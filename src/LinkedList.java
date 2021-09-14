public class LinkedList {

    private Node headNode = null;

    public void addHeadNode(int x, int y){
        Node oNode = new Node();
        oNode.xPosition = x;
        oNode.yPosition = y;
        oNode.nextNode = headNode;
        headNode = oNode;
    }
    public Node removeHeadNode(){
        Node oNode;
        oNode = headNode;
       if(headNode != null) {
           headNode = headNode.nextNode;
       }
       return oNode; 
    }
}

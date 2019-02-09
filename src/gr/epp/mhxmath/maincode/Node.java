/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.epp.mhxmath.maincode;

/**
 *
 * @author NZXT
 */
public class Node {

    Node left;

    Node right;

    String value;

    public Node(String value) {
        this.value = value;
    }

    public void insert(Node node, String value) {
        //System.out.println(value);
        if (value.compareTo(node.value) < 0) {
            //System.out.println("Left Inside");
            if (node.left != null) {
                insert(node.left, value);
            } else {
                //System.out.println("  Inserted " + value + " to left of "+ node.value);
                node.left = new Node(value);
            }
        } else if (value.compareTo(node.value) > 0) {
            //System.out.println("Right Inside");
            if (node.right != null) {
                insert(node.right, value);
            } else {
                //System.out.println("  Inserted " + value + " to right of "+ node.value);
                node.right = new Node(value);
            }
        }
    }

    public void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println("  Traversed " + node.value);
            printInOrder(node.right);
        }
    }

}

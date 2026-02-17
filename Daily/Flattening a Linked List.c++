class Node {
public:
    int data;
    Node* next;
    Node* bottom;

    Node(int x) {
        data = x;
        next = NULL;
        bottom = NULL;
    }
};


class Solution {
  public:
    Node *flatten(Node *root) {
        // code here
        if(root== NULL || root->next==NULL)
            return root;
        Node *mergehead=flatten(root->next);
        return merge(root,mergehead);
    }
    Node *merge(Node *list1 , Node *list2)
    {
        Node *dummy = new Node(-1);
        Node *res=dummy;
        while(list1!=NULL && list2 !=NULL)
        {
            if(list1->data <list2->data)
            {
                res->bottom=list1;
                res=list1;
                list1=list1->bottom;
            }
            else
            {
                res->bottom=list2;
                res=list2;
                list2=list2->bottom;
            }
        res->next=NULL;
        }
        if(list1) res->bottom=list1;
        else res->bottom=list2;
        return dummy->bottom;
    }
};
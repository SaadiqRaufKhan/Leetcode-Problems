/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        if(!head || !head->next) return head;

        // add a dummy node at the begging of list
        ListNode* dummy = new ListNode(1000);
        dummy->next = head;

        ListNode* pivot = head;         // partitioning point
        ListNode* prevPivot = dummy;    // point after which nodes need to be appended

        // find the partion point i.e. first node with value >= x
        while(pivot && pivot->val < x) {
            pivot = pivot->next;
            prevPivot = prevPivot->next;
        }
        
        // corner case: list already satisfies the condition
        if(!pivot) return head;

        // all pointers ready, now do swapping of nodes 
        // only those nodes needs to be adjusted that are after pivot
        ListNode* temp = pivot->next;
        ListNode* prevTemp = pivot;
        while(temp) {
            if(temp->val < x) {
                // modify connections
                prevTemp->next = temp->next;
                prevPivot->next = temp;
                temp->next = pivot;

                // adjust pointers
                prevPivot = temp;
                temp = prevTemp->next;
            }
            else {
                temp = temp->next;
                prevTemp = prevTemp->next;
            }
        }
        ListNode* finalHead = dummy->next;
        delete dummy;
        return finalHead;

    }
};
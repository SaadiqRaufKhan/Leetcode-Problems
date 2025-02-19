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
    ListNode* rotateRight(ListNode* head, int k) {
        if(!head || !head->next) {
            return head;
        }
        // 1. find the length and tail of ll
        int len = 1;
        ListNode* tail = head;
        while(tail->next != NULL) {
            tail = tail->next;
            len++;
        }

        // 2. reduce k using modulo 
        k = k % len;

        // 3. connect tail with head
        tail->next = head;

        // 4. find the node at cut-off point & move head forward
        int pos = 1;
        while(pos != len-k) {
            head = head->next;
            pos++;
        }
        
        // 5. cut-off the list at pos = len-k from, and make the node at pos = len-k+1 as the new head
        ListNode* newHead = head->next;
        head->next = NULL;

        return newHead;
    }
};


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
        if(!head) return head;
        
        int len = 0;
        ListNode* temp = head;

        while(temp) {
            len++;
            temp = temp->next;
        }

        int k2 = k % len;

        if(k2 == 0) return head;

        int count = 0;
        temp = head;
        while(count < len - k2 - 1) {
            temp = temp->next;
            count++;
        }
        ListNode* finalHead = temp->next;
        temp->next = NULL;

        ListNode* temp2 = finalHead;
        while(temp2->next) {
            temp2 = temp2->next;
        }
        temp2->next = head;
        return finalHead;
    }
};













// if(head == NULL || head->next == NULL) {
//             return head;
//         }
//         // 1a. find the length and tail of ll
//         int len = 1;
//         ListNode* temp = head;
//         while(temp->next != NULL) {
//             temp = temp->next;
//             len++;
//         }

//         // 1b. reduce k using modulo 
//         k = k % len;

//         // 2. connect tail with head
//         temp->next = head;

//         // 3. find the node at cut-off point & move head forward
//         int pos = 1;
//         while(pos != len-k) {
//             pos++;
//             head = head->next;
//         }
        
//         // 4. cut-off the list at pos = len-k from 
//         // and make the node at pos = len-k+1 as the new head
//         ListNode* newHead = head->next;
//         head->next = NULL;

//         return newHead;
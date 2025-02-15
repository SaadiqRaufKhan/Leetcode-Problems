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
    ListNode* deleteDuplicates(ListNode* head) {

        if (!head || !head->next) return head;

        ListNode* dummy = new ListNode(-1); // Dummy node before head
        dummy->next = head;

        ListNode* prev = dummy; // Previous confirmed unique node
        ListNode* curr = head;  // Current node to check

        while (curr) {
            bool isDuplicate = false;
            
            // Skip all nodes with the same value
            while (curr->next && curr->val == curr->next->val) {
                isDuplicate = true;
                ListNode* temp = curr;
                curr = curr->next;
                delete temp; // Free memory of duplicate node
            }

            if (isDuplicate) {
                // Remove duplicates by skipping them
                prev->next = curr->next;
                delete curr; // Free memory of the last duplicate node
            } else {
                // Move prev forward if no duplicate was found
                prev = prev->next;
            }
            
            // Move curr forward
            curr = prev->next;
        }

        ListNode* newHead = dummy->next;
        delete dummy; // Free dummy node memory
        return newHead;
    }
};



        // // corner case
        // if(head == NULL || head->next == NULL) return head;

        // // add an extra dummy node before the head and call it prev
        // // this will avoid the overhead of computing prev
        // ListNode* prev = new ListNode(0);
        // prev->next = head;
        // ListNode* curr = head;
        // bool flag = false;

        // while(curr->next != NULL) {
        //     if(curr->val == curr->next->val) {
        //         flag = true;
        //         ListNode* duplicate = curr->next;
        //         curr->next = duplicate->next;
        //         delete duplicate;
        //     }
        //     else {
        //         // this means that the curr node also needs to be deleted
        //         if(flag) {
        //             flag = false;
        //             // check if the curr node is head node or note
        //             if(curr == head) {
        //                 head = curr->next;
        //                 delete curr;
        //                 curr = head;
        //             } 
        //             else {
        //                 prev->next = curr->next;
        //                 delete curr;
        //                 curr = prev->next;
        //             }
        //         }
        //         else {
        //             prev = curr;
        //             curr = curr->next;
        //         }
        //     }
        // }
        // if(flag) {
        //     if(curr == head) {
        //         head = NULL;
        //         delete curr;
        //     }
        //     else {
        //         prev->next = NULL;
        //         delete curr;
        //     }
        // }
        // return head;
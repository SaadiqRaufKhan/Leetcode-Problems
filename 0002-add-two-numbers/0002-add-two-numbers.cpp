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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        if(l1 == NULL) {
            return l2;
        }
        if(l2 == NULL) {
            return l1;
        }

        int carry = 0;
        ListNode *head = NULL;
        ListNode *tail = NULL;
        while(l1 != NULL && l2 != NULL) {
            int sum = (l1->val) + (l2->val) + carry;
            carry = (sum >= 10) ? 1 : 0;
            if(carry == 1)
                sum = sum % 10;
            
            ListNode* node = new ListNode(sum);
            if(head == NULL) {
                head = node;
                tail = node;
            }
            else {
                tail->next = node;
                tail = node;
            }

            l1 = l1->next;
            l2 = l2->next;
        }

        if(l2 == NULL) {
            while(l1 != NULL) {
                int sum = (l1->val) + carry;
                carry = (sum >= 10) ? 1 : 0;
                if(carry == 1)
                    sum = sum % 10;
                ListNode* node = new ListNode(sum);
                tail->next = node;
                tail = node;
                l1 = l1->next;
            }
            if(carry == 1) {
                ListNode* node = new ListNode(1);
                tail->next = node;
                tail = node;
            }
        }
        if(l1 == NULL && l2 != NULL) {
            while(l2 != NULL) {
                int sum = (l2->val) + carry;
                carry = (sum >= 10) ? 1 : 0;
                if(carry == 1)
                    sum = sum % 10;
                ListNode* node = new ListNode(sum);
                tail->next = node;
                tail = node;
                l2 = l2->next;
            }
            if(carry == 1) {
                ListNode* node = new ListNode(1);
                tail->next = node;
                tail = node;
            }
        }


        return head;
    }
};
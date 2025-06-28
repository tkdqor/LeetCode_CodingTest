/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0); // 1. 결과 연결 리스트의 더미 헤드 노드를 생성합니다. 이는 결과 리스트의 시작을 쉽게 다루기 위함입니다.
        ListNode result = node;          // 2. 결과 리스트의 실제 시작점을 나중에 반환하기 위해 더미 헤드를 가리키는 포인터 'result'를 저장합니다.
        int sum = 0;                     // 3. 현재 자릿수의 합과 다음 자릿수로 넘어갈 올림(carry) 값을 저장할 변수 'sum'을 0으로 초기화합니다.

        while (l1 != null || l2 != null || sum > 0) { // 4. l1, l2 둘 중 하나라도 남았거나, 마지막에 올림(carry) 값이 남아있으면 루프를 계속합니다.
            if (l1 != null) {            // 5. 첫 번째 숫자 리스트(l1)가 아직 끝나지 않았다면,
                sum += l1.val;           //    현재 l1 노드의 값을 'sum'에 더합니다.
                l1 = l1.next;            //    l1 포인터를 다음 노드로 이동시켜 다음 자릿수를 처리할 준비를 합니다.
            }

            if (l2 != null) {            // 6. 두 번째 숫자 리스트(l2)가 아직 끝나지 않았다면,
                sum += l2.val;           //    현재 l2 노드의 값을 'sum'에 더합니다.
                l2 = l2.next;            //    l2 포인터를 다음 노드로 이동시켜 다음 자릿수를 처리할 준비를 합니다.
            }

            node.next = new ListNode(sum % 10); // 7. 현재 자릿수의 합('sum')을 10으로 나눈 나머지(sum % 10)는 현재 자릿수의 값입니다.
                                             //    이 값을 가진 새로운 노드를 생성하여 'node'가 현재 가리키는 노드의 'next'에 연결합니다.
                                             //    (예: sum이 15이면 5가 현재 자릿수 값)
            sum /= 10;                       // 8. 현재 자릿수의 합('sum')을 10으로 나눈 몫(sum / 10)은 다음 자릿수로 넘어갈 올림(carry) 값입니다.
                                             //    이 값을 'sum'에 저장하여 다음 루프에서 사용합니다.
                                             //    (예: sum이 15이면 1이 다음 자릿수로 넘어감)

            node = node.next;                // 9. 'node' 포인터를 새로 생성된 노드(node.next)로 이동시킵니다.
                                             //    이는 다음 자릿수의 노드를 연결할 준비를 하기 위함입니다.
        }

        return result.next;              // 10. 'result'는 더미 헤드 노드('node = new ListNode(0)')를 가리키고 있었으므로,
                                         //     실제 결과 리스트의 시작은 더미 헤드의 다음 노드('result.next')입니다.
                                         //     이것을 반환합니다.
    }
}

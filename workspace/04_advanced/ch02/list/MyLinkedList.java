package ch02.list;

public class MyLinkedList implements MyList {
    // inner 클래스 생성
    private class Node {
        /**
         * 저장할 객체
         */
        private Object data;

        /**
         * 연결된 다음 노드를 참조하는 필드
         */
        private Node nextNode;

        Node(Object data) {
            this.data = data;
            this.nextNode = null;
        }
    }

    /**
     * 첫 번째 노드
     */
    private Node header;

    /**
     * 전체 요소의 수
     */
    private int size;

    public MyLinkedList() {
        this.header = new Node(null);
    }

    /**
     * data를 첫번째 요소로 추가
     *
     * @param data 추가할 요소
     */
    public void appendFirst(Object data) {
        Node node = new Node(data);
        node.nextNode = header.nextNode;
        header.nextNode = node;
        size++;
    }

    /**
     * data를 index 위치에 삽입
     *
     * @param index data가 삽입될 위치
     * @param data  삽입할 데이터
     */
    public void add(int index, Object data) {
        if (index == 0) {
            appendFirst(data);
        } else {
            Node newNode = new Node(data);
            Node prevNode = getNode(index - 1);
            newNode.nextNode = prevNode.nextNode;
            prevNode.nextNode = newNode;
            size++;
        }
    }

    public void add(Object data) {add(size, data);}

    /**
     * 리스트의 첫번째 요소를 삭제한다.
     */
    private void removeFirst() {
        // TODO 첫번째 노드의 다음 노드를 첫번째 노드로 지정하고
        Node firstNode = header.nextNode;
        header.nextNode = firstNode.nextNode;
        // 첫번째 노드의 데이터를 반환한 후 사이즈 감소
        size--;
    }

    /**
     * 지정한 index 요소를 삭제한다.
     *
     * @param index 삭제한 요소의 index
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        } else if (index == 0) {
            removeFirst();
        }

        // TODO 지정한 인덱스의 이전 노드와 해당 노드,
        // 다음 노드를 찾은 후
        Node pNode = getNode(index - 1); // 삭제할 노드의 이전 노드
        Node rNode = pNode.nextNode; // 삭제할 노드
        Node nNode = rNode.nextNode; // 삭제할 노드의 다음 노드

        pNode.nextNode = nNode;
        size--;
    }

    /**
     * 지정한 인덱스의 요소를 반환
     *
     * @param index 요소의 위치
     * @return index 위치의 요소
     */
    public Object get(int index) {return getNode(index).data;}

    /**
     * 전체 요소의 수를 반환
     *
     */
    public int size() {return size;}

    public String toString() {
        StringBuffer result = new StringBuffer("[");
        Node node = header.nextNode;
        if (node != null) {
            result.append(node.data);
            node = node.nextNode;
            while (node != null) {
                result.append(", ");
                result.append(node.data);
                node = node.nextNode;
            }
        }
        result.append("]");
        return result.toString();
    }

    /**
     * index 위치의 Node를 찾아서 반환
     *
     * @param index 찾을 노드의 위치
     * @return 찾아낸 Node를 반환
     */
    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            String errorMessage = String.format("Index %d is exceeded List's Size %d", index, size);
            throw new IndexOutOfBoundsException(errorMessage);
        }
        Node targetNode = header.nextNode;
        for (int i = 0; i < index; i++) {targetNode = targetNode.nextNode;}
        return targetNode;
    }

}

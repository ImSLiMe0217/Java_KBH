package ch02.list;

/**
 * 배열의 불편한 점
 * 생성 시 길이 지정
 * 생성된 배열의 길이를 변경할 수 없음
 * 요소 추가, 삭제, 변경이 어려움
 */
public class MyArray implements MyList {
    /**
     * 내부적으로 요소를 저장하는 배열 선언
     */
    private Object[] data;

    /**
     * 배열에 실제 담겨있는 요소의 개수
     */
    private int count;

    /**
     * 기본 생성자
     * 초기 배열의 크기를 10개로 지정
     */
    public MyArray() {
        this(10);
    }

    /**
     * 초기 배열의 크기를 지정한 size로 생성한다
     *
     * @param size 배열의 초기 크기
     */
    public MyArray(int size) {
//        count = size;
        this.data = new Object[size];
    }

    /**
     * 배열의 마지막 위치에 지정한 elem을 추가한다.
     *
     * @param elem 배열의 추가되는 원소
     */
    public void add(Object elem) {
        add(count, elem);
    }

    /**
     * 지정한 index의 elem을 삽입
     *
     * @param index 삽입할 위치
     * @param elem  삽입할 요소
     */
    public void add(int index, Object elem) {
        if (index < 0 || index > count) {
            String errorMessage = String.format("Index %d is not available", index);
            throw new ArrayIndexOutOfBoundsException(errorMessage);
        }
        if (count >= data.length) {
            Object[] temp = new Object[(int) (data.length * 1.5)];
            for (int i = 0; i < data.length; i++) temp[i] = data[i];
            data = temp;
        }
        System.arraycopy(data, index, data, index + 1, count - index);
        data[index] = elem;
        count++;
    }

    /**
     * 지정한 index의 요소를 삭제한다
     *
     * @param index 대상 위치
     */
    public void remove(int index) {
        if (index >= count) {
            String errorMessage = String.format("Index %d is exceeded Array's Length %d", index, count);
            throw new ArrayIndexOutOfBoundsException(errorMessage);
        } else if (index < 0) {
            String errorMessage = String.format("Index %d is not available", index);
            throw new ArrayIndexOutOfBoundsException(errorMessage);
        }
        System.arraycopy(data, index + 1, data, index, count - index - 1);
        data[--count] = null;
    }

    /**
     * 지정한 위치의 데이터를 반환
     *
     * @param index 반환할 데이터의 위치
     * @return 지정한 위치의 데이터
     */
    public Object get(int index) {
        if (index >= count) {
            String errorMessage = String.format("Index %d is exceeded Array's Length %d", index, count);
            throw new ArrayIndexOutOfBoundsException(errorMessage);
        } else if (index < 0) {
            String errorMessage = String.format("Index %d is not available", index);
            throw new ArrayIndexOutOfBoundsException(errorMessage);
        }
        return data[index];
    }

    public int size() {
        return count;
    }

    @Override
    public String toString() {
//        StringBuffer str = new StringBuffer("["); // 멀티 스레드 환경에 적합
        StringBuilder str = new StringBuilder("["); // 싱글 스레드 환경에 적합

        for (int i = 0; i < count; i++) {
            if (data[i] != null) str.append(data[i]);
            if (i != count - 1) str.append(", ");
        }
        str.append("]");

        return str.toString();
    }
}
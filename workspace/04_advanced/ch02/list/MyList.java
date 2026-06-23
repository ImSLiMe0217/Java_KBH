package ch02.list;

public interface MyList {
    /**
     * 지정한 데이터를 마지막 요소로 추가
     *
     * @param obj 추가할 데이터
     */
    void add(Object obj);

    /**
     * 지정한 데이터를 index 위치에 삽입
     *
     * @param index 삽입할 위치
     * @param obj   삽입할 데이터
     */
    void add(int index, Object obj);

    /**
     * 지정한 index의 데이터를 삭제
     *
     * @param index 삭제할 위치
     */
    void remove(int index);

    /**
     * 지정한 index의 데이터를 조회
     *
     * @param index 조회할 데이터의 위치
     * @return Object 타입의 데이터를 반환
     */
    Object get(int index);

    /**
     * list 내의 원소의 갯수를 반환
     *
     * @return int타입
     */
    int size();
}

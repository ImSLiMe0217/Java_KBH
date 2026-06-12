package ch12.mycar;

public class BusCompany {
    private Bus[] busList;
    private int totalIncome;

    public BusCompany(Bus[] busList) {
        this.busList = busList;
    }

    private void refreshTotalIncome() {
        totalIncome = 0;
        for (Bus bus : busList) {
            totalIncome += bus.getIncome();
        }
    }

    void getInfo() {
        refreshTotalIncome();
        System.out.println("--- 전체 버스 정보 ---");
        for (Bus bus : busList) {
            bus.getInfo();
        }
        System.out.println("----------------");
        System.out.printf("보유 버스 수\t: %d대\n총 수익\t\t: %d원", busList.length, totalIncome);
    }
}

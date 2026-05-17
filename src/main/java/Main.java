import employee.*; // Developer, Designer 등이 포함된 패키지
import employee.designer.Designer;
import employee.designer.GraphicDesigner;
import employee.designer.UIUXDesigner;
import employee.developer.AIEngineer;
import employee.developer.Developer;
import employee.developer.FullStackEngineer;
import employee.developer.InfraEngineer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();
        initializeEmployees(manager);

        label:
        while (true) { // 프로그램이 종료 선택 전까지 계속 반복되도록 설정
            showMainPage();
            String input = sc.nextLine();

            switch (input){
                case "1":
                    // [직원 등록]
                    System.out.println("직군 선택: 1. 개발자 2. 디자이너 (기본: 일반 직원)");
                    String type = sc.nextLine();

                    Employee employee = null;
                    if(type.equals("1")){
                        System.out.println("직무 선택: 1. 풀스택 엔지니어 2. AI 엔지니어 3. 인프라 엔지니어");
                        employee = setEmployee(sc, employee);
                    }else if(type.equals("2")){
                        System.out.println("직무 선택: 1. UI/UX디자이너 2. 그래픽 디자이너");
                        employee = setEmployee(sc, employee);
                    } else {
                        //employee = new Employee(0L, name, age, email);
                    }

                    if(employee != null){
                        manager.add(employee);
                        System.out.println("* 등록 완료: " + employee);
                    }

                    break;
                case "2":
                    // [직원 조회]
                    if(manager.isEmpty()){
                        System.out.println("등록된 직원이 없습니다.");
                    } else{
                        System.out.println("\n1. 전체 직원 조회  2. 직원ID로 조회");
                        int index = Integer.parseInt(sc.nextLine());

                        if(index == 1){
                            for (Employee emp : manager.findAll()) {
                                emp.showInfo();
                            }
                        }else if(index == 2){
                            System.out.print("조회할 직원의 ID를 입력하세요: ");
                            long targetId = Long.parseLong(sc.nextLine());
                            if(manager.exists(targetId)){
                                Employee target = manager.findById(targetId);
                                target.showInfo();
                            }else{
                                System.out.println("해당 ID의 직원을 찾을 수 없습니다.");
                            }
                        }
                    }

                    break;
                case "3":
                    // [직원 삭제]
                    System.out.print("삭제할 직원의 ID를 입력하세요: ");
                    long targetId = Long.parseLong(sc.nextLine());

                    if(manager.exists(targetId)){
                        Employee removed = manager.remove(targetId);
                        System.out.println("ID " + targetId + " (" + removed.getName() + ") 직원이 삭제되었습니다.");
                    }else{
                        System.out.println("해당 ID의 직원을 찾을 수 없습니다.");
                    }
                    break;
                case "4":
                    System.out.println("프로그램을 종료합니다.");
                    break label; // while 루프 탈출
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                    break;
            }
        }
    }

    private static Employee setEmployee(Scanner sc, Employee employee) {
        int index = Integer.parseInt(sc.nextLine());

        System.out.print("이름 : ");
        String name = sc.nextLine();
        System.out.print("나이 : ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("이메일 : ");
        String email = sc.nextLine();

        if(employee instanceof Developer){
            System.out.print("메인 언어 : ");
            String mainLanguage = sc.nextLine();
            System.out.print("프레임워크 : ");
            String framework = sc.nextLine();
            if(index == 1){
                employee = new FullStackEngineer(name, age, email, mainLanguage, framework);
            }else if(index == 2){
                employee = new AIEngineer(name, age, email, mainLanguage, framework);
            }else if(index == 3){
                employee = new InfraEngineer(name, age, email, mainLanguage, framework);
            }else{
                System.out.println("잘못된 선택입니다."); // 다시 돌아갈 방식 구현
            }
        }else if(employee instanceof Designer){
            System.out.println("메인 툴 : ");
            String mainDesignTool = sc.nextLine();
            if(index == 1){
                employee = new UIUXDesigner(name, age, email, mainDesignTool);
            }else if(index == 2){
                employee = new GraphicDesigner(name, age, email, mainDesignTool);
            }else{
                System.out.println("잘못된 선택입니다."); // 다시 돌아갈 방식 구현
            }
        }
        return employee;
    }

    private static void showMainPage(){
        System.out.println("\n========================================");
        System.out.println("           직원 관리 시스템");
        System.out.println("========================================");
        System.out.println("1. 직원등록 | 2. 직원조회 | 3. 직원삭제 | 4. 종료");
        System.out.print("메뉴 선택 > ");
    }

    private static void initializeEmployees(EmployeeManager manager){
        manager.add(new FullStackEngineer("finn", 25, "finn1234@gmail.com", "java", "Spring"));
        manager.add(new AIEngineer("gildong", 27, "gildong1234@gmail.com", "python", "Pytorch"));
    }
}

import Employee.Employee;
import Employee.EmployeeManager;
import Employee.designer.GraphicDesigner;
import Employee.designer.UIUXDesigner;
import Employee.developer.AIDeveloper;
import Employee.developer.FullStackDeveloper;
import Employee.developer.InfraDeveloper;
import enumType.menu.*;
import validation.InputValidator;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();
        initializeEmployees(manager);
        while (true) {
            showMainPage();
            String index = sc.nextLine();

            MainMenu menu = MainMenu.from(index);
            if(menu == null){
                System.out.println("잘못된 입력입니다.");
                continue;
            }
            switch (menu) {
                case ADD_EMPLOYEE -> addEmployee(sc, manager);
                case FIND_EMPLOYEE -> findEmployee(sc, manager);
                case DELETE_EMPLOYEE -> deleteEmployee(sc, manager);
                case MANAGE_WORK -> manageWorkEmployee(sc, manager);
                case EXIT -> {
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;
                }
            }
        }
    }


    private static void addEmployee(Scanner sc, EmployeeManager manager) {
        while (true){
            System.out.println("-------------------------------------------------------------");
            System.out.println("             1. 개발자 | 2. 디자이너 | 3. 뒤로가기");
            System.out.println("-------------------------------------------------------------");
            System.out.print("메뉴 선택 > ");
            String index = sc.nextLine();

            EmployeeTypeMenu menu = EmployeeTypeMenu.from(index);
            if(menu == null){
                System.out.println("잘못된 선택입니다.");
                continue;
            }
            Employee employee = null;
            switch (menu) {
                case DEVELOPER -> employee = createDeveloper(sc); //개발자 생성
                case DESIGNER -> employee = createDesigner(sc); //디자이너 생성
                case BACK -> {
                    return;
                }
            }
            if(employee != null){
                manager.addEmployee(employee);
                System.out.println("* 등록 완료: " + employee);
            }
        }
    }

    private static void manageWorkEmployee(Scanner sc, EmployeeManager manager) {

        while(true){
            List<Employee> notWorkingEmployees = manager.findNotWorking();
            List<Employee> workingEmployees = manager.findWorking();

            System.out.println("---------------------------------------------------------------");
            System.out.println("       1. 작업 할당 | 2. 작업 해제 | 3. 외근 관리 | 4. 뒤로가기");
            System.out.println("---------------------------------------------------------------");
            System.out.print("메뉴 선택 > ");
            String index = sc.nextLine();

            ManageWorkerMenu menu = ManageWorkerMenu.from(index);
            if(menu == null){
                System.out.println("잘못된 선택입니다.");
                continue;
            }

            switch (menu) {
                case ASSIGN -> {
                    while(true){
                        if(notWorkingEmployees.isEmpty()){
                            System.out.println("---------------------------------------------------");
                            System.out.println("               모든 직원이 작업 중입니다.");
                            System.out.println("---------------------------------------------------");
                        }else{
                            System.out.println("---------------------------------------------------");
                            System.out.println("               작업 중이 아닌 직원 목록");
                            for (Employee employee : notWorkingEmployees) {
                                System.out.println("[ID] : " + employee.getId() + " | [이름] : " + employee.getName());
                            }
                            System.out.println("----------------------------------------------------");

                            System.out.print("작업에 할당할 직원의 ID를 입력하세요(0: 뒤로가기) : ");
                            String input = sc.nextLine();
                            Long targetId = InputValidator.parseType(input, Long.class);
                            if(targetId == null){
                                System.out.println("잘못된 입력입니다.");
                            }else if(targetId == 0){
                                break;
                            }else{
                                Employee target = manager.findById(targetId);

                                if(manager.exists(targetId)){
                                    if(target.isWorking()){
                                        System.out.println("[ID]: "  + target.getId() + " [이름]: " + target.getName()+"은(는) 이미 작업 중 입니다." );
                                    }else{
                                        System.out.println(target.showStartWork());
                                    }
                                }else {
                                    System.out.println("해당 직원을 찾을 수 없습니다.");
                                }
                            }
                        }
                    }
                }
                case RELEASE -> {
                    while(true){
                        if(workingEmployees.isEmpty()){
                            System.out.println("----------------------------------------------------");
                            System.out.println("               작업 중인 직원이 없습니다.");
                            System.out.println("----------------------------------------------------");
                        }else{
                            System.out.println("----------------------------------------------------");
                            System.out.println("                  작업 중인 직원 목록");
                            for (Employee employee : workingEmployees) {
                                System.out.println("[ID] : " + employee.getId() + " | [이름] : " + employee.getName());
                            }
                            System.out.println("----------------------------------------------------");
                            System.out.print("작업 해제할 직원의 ID를 입력하세요(0: 뒤로가기) : ");


                            String input = sc.nextLine();
                            Long targetId = InputValidator.parseType(input, Long.class);

                            if(targetId == null){
                                System.out.println("잘못된 입력입니다.");
                            }else if(targetId == 0){
                                break;
                            }else{
                                Employee target = manager.findById(targetId);
                                if(manager.exists(targetId)){
                                    if(!target.isWorking()){
                                        System.out.println("[ID]: "  + target.getId() + " [이름]: " + target.getName()+"은(는) 이미 작업 중이 아닙니다." );
                                    }else{
                                        System.out.println(target.showEndWork());
                                    }
                                }else {
                                    System.out.println("해당 직원을 찾을 수 없습니다.");
                                }
                            }
                        }
                    }
                }
                case OUTSIDE -> {
                    Object monitor = manager.getMonitor();

                    System.out.printf("현재 외근 인원: %d명/%d명\n외근 투입할 직원 ID 입력 (중복 가능, 공백으로 구분 | 0: 뒤로가기) : ", manager.getOutsideWorker(), manager.findAll().size() / 3);

                    String[] ids = sc.nextLine().split(" ");
                    for (String id : ids) {
                        Long targetId = InputValidator.parseType(id, Long.class);
                        if(targetId == null){
                            System.out.println("잘못된 입력입니다.");
                        }else if(targetId == 0){
                            break;
                        }else{
                            Employee employee = manager.findById(targetId);
                            if(!manager.exists(targetId)){
                                System.out.println("해당 ID의 직원이 존재하지 않습니다.");
                            }else{
                                if(!employee.isWorking()){
                                    if(!manager.valOutsideWorker()){
                                        System.out.println("외근 가능한 인원이 초과되었습니다!");
                                        break;
                                    }
                                    Thread t = new Thread(() -> {
                                        try {
                                            manager.workOutside(employee);
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                    });
                                    t.start();
                                    synchronized (monitor){//메인스레드에서 락 획득
                                        try {
                                            monitor.wait(); // 메인스레드에서 락 반납 후 대기 -> notify 받은 후 락 재획득 후 종료
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                    }
                                }else{
                                    System.out.println("|직원 " + employee.getName()+ "은(는) 이미 작업 중입니다!|");
                                }

                            }
                        }
                    }
                }
                case BACK -> {
                    return;
                }
            }
        }
    }

    private static void findEmployee(Scanner sc, EmployeeManager manager) {
        while (true) {
            if(manager.isEmpty()){
                System.out.println("등록된 직원이 없습니다.");
                return;
            }else{
                System.out.println("-------------------------------------------------------------");
                System.out.println("        1. 전체 직원 조회 | 2. 직원ID로 조회 | 3. 뒤로 가기");
                System.out.println("-------------------------------------------------------------");
                System.out.print("메뉴 선택 > ");
                String index = sc.nextLine();

                FindEmployeeMenu menu = FindEmployeeMenu.from(index);
                if(menu == null){
                    System.out.println("잘못된 입력입니다.");
                    continue;
                }

                switch (menu) {
                    case FIND_ALL -> {
                        for (Employee emp : manager.findAll()) {
                            emp.showInfo();
                        }
                    }
                    case FIND_BY_ID -> {
                        while(true){
                            System.out.print("조회할 직원의 ID를 입력하세요(0: 뒤로가기): ");
                            String input = sc.nextLine();

                            Long targetId = InputValidator.parseType(input, Long.class);
                            if (targetId == null) {
                                System.out.println("잘못된 입력입니다.");
                            }else if(targetId == 0){
                                break;
                            }else {
                                if (manager.exists(targetId)) {
                                    Employee target = manager.findById(targetId);
                                    target.showInfo();
                                } else {
                                    System.out.println("해당 ID의 직원을 찾을 수 없습니다.");
                                }
                            }
                        }
                    }
                    case BACK -> {
                        return;
                    }
                }
            }
        }

    }

    private static void deleteEmployee(Scanner sc, EmployeeManager manager) {

        while(true){
            if(!manager.isEmpty()){
                System.out.print("삭제할 직원의 ID를 입력하세요(0 : 뒤로가기) : ");
                long targetId = Long.parseLong(sc.nextLine());

                if(targetId == 0){
                    return;
                }else{
                    if(manager.exists(targetId)){
                        Employee removed = manager.removeEmployee(targetId);
                        System.out.println("ID " + targetId + " (" + removed.getName() + ") 직원이 삭제되었습니다.");
                    }else{
                        System.out.println("해당 ID의 직원을 찾을 수 없습니다.");
                    }
                }
            }else{
                System.out.println("직원이 없습니다.");
                return;
            }

        }

    }

    private static void showMainPage(){
        System.out.println("=============================================================");
        System.out.println("                       직원 관리 시스템");
        System.out.println("=============================================================");
        System.out.println("1. 직원등록 | 2. 직원조회 | 3. 직원삭제 | 4. 작업 현황 | 5. 종료");
        System.out.print("메뉴 선택 > ");
    }

    private static Employee createDeveloper(Scanner sc){
        System.out.println("직무 선택 : 1. 풀스택 개발자 | 2. AI 개발자 | 3. 인프라 개발자 | 4. 뒤로 가기");
        System.out.print("메뉴 선택 > ");
        String index = sc.nextLine();
        DeveloperTypeMenu menu = DeveloperTypeMenu.from(index);

        if (menu == null) {
            System.out.println("잘못된 입력입니다.");
            return null;
        }
        if(menu == DeveloperTypeMenu.BACK){
            return null;
        }
        System.out.print("이름 : ");
        String name = sc.nextLine();
        System.out.print("나이 : ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("이메일 : ");
        String email = sc.nextLine();
        System.out.print("메인 언어 : ");
        String mainLanguage = sc.nextLine();

        switch (menu) {
            case FULLSTACK -> {
                System.out.print("프론트엔드 프레임워크 : ");
                String frontendFramework = sc.nextLine();
                System.out.print("백엔드 프레임워크 : ");
                String backendFramework = sc.nextLine();
                return new FullStackDeveloper(name, age, email, mainLanguage, frontendFramework, backendFramework);
            }
            case AI -> {
                System.out.print("전문 필드 : ");
                String mainField = sc.nextLine();
                return new AIDeveloper(name, age, email, mainLanguage, mainField);
            }
            case INFRA -> {
                System.out.print("메인 플랫폼 : ");
                String mainPlatform = sc.nextLine();
                return new InfraDeveloper(name, age, email, mainLanguage, mainPlatform);
            }
        }
        return null;
    }
    private static Employee createDesigner(Scanner sc){
        System.out.println("직무 선택 : 1. UI/UX 디자인 | 2. 그래픽 디자이너 | 3. 뒤로 가기");
        System.out.print("메뉴 선택 > ");
        String index = sc.nextLine();
        DesignerTypeMenu menu = DesignerTypeMenu.from(index);
        if(menu == null){
            System.out.println("잘못된 선택입니다.");
            return null;
        }
        if(menu== DesignerTypeMenu.BACK){
            return null;
        }

        System.out.print("이름 : ");
        String name = sc.nextLine();
        System.out.print("나이 : ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("이메일 : ");
        String email = sc.nextLine();
        System.out.print("메인 디자인 툴 : ");
        String designTool = sc.nextLine();

        switch (menu) {
            case UIUX_DESIGNER -> {
                System.out.print("메인 프로토타입 툴 : ");
                String prototypeTool = sc.nextLine();
                return new UIUXDesigner(name, age, email, designTool, prototypeTool);
            }
            case GRAPHIC_DESIGNER -> {
                System.out.print("메인 그래픽 작업 유형 : ");
                String graphicAssertType = sc.nextLine();
                return new GraphicDesigner(name, age, email, designTool, graphicAssertType);
            }
        }
        return null;
    }

    private static void initializeEmployees(EmployeeManager manager){
        manager.addEmployee(new FullStackDeveloper("Finn", 25, "finn1234@gmail.com", "java", "React", "Spring"));
        manager.addEmployee(new FullStackDeveloper("Sanghyeon", 26, "nsh1234@gmail.com","typescript", "React", "Nodejs"));

        manager.addEmployee(new AIDeveloper("Gildong", 27, "gildong1234@gmail.com", "python", "Computer Vision"));
        manager.addEmployee(new AIDeveloper("Chunsik", 28, "chunsik1234@gmail.com", "python", "Computer Vision"));

        manager.addEmployee(new InfraDeveloper("Sam",27,"sam1234@gmail.com","java", "AWS"));
        manager.addEmployee(new InfraDeveloper("William",37,"william1234@gmail.com","typescript", "AWS"));

        manager.addEmployee(new UIUXDesigner("Jun", 32, "jun123@gmail.com", "Figma", "Figma Prototype"));
        manager.addEmployee(new UIUXDesigner("July", 32, "july123@gmail.com", "Figma", "Figma Prototype"));
        manager.addEmployee(new GraphicDesigner("Emma", 27, "emma123@gmail.com", "Adobe Illustrator", "Poster"));
    }
}

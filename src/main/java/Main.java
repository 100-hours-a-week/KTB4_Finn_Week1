import Employee.Employee;
import Employee.EmployeeManager;
import Employee.designer.GraphicDesigner;
import Employee.designer.UIUXDesigner;
import Employee.developer.AIDeveloper;
import Employee.developer.FullStackDeveloper;
import Employee.developer.InfraDeveloper;
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

            switch (index){
                case "1":
                    addEmployee(sc, manager);
                    break;
                case "2":
                    findEmployee(sc, manager);
                    break;
                case "3":
                    deleteEmployee(sc, manager);
                    break;
                case "4":
                    manageWorkEmployee(sc, manager);
                    break;
                case "5":
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                    break;
            }
        }
    }




    private static void addEmployee(Scanner sc, EmployeeManager manager) {
        while (true){
            System.out.println("-------------------------------------------------------------");
            System.out.println("                1. 개발자 2. 디자이너 3. 뒤로가기");
            System.out.println("-------------------------------------------------------------");
            System.out.print("메뉴 선택 > ");
            String index = sc.nextLine();

            Employee employee = null;
            switch (index) {
                case "1" -> employee = createDeveloper(sc); //개발자 생성

                case "2" -> employee = createDesigner(sc); //디자이너 생성

                case "3" -> {
                    return;
                }
                default -> System.out.println("잘못된 선택입니다.");
            }

            if(employee != null){
                manager.add(employee);
                System.out.println("* 등록 완료: " + employee);
            }
        }
    }

    private static void manageWorkEmployee(Scanner sc, EmployeeManager manager) {

        while(true){
            List<Employee> notWorkingEmployees = manager.findNotWorking();
            List<Employee> workingEmployees = manager.findWorking();

            System.out.println("---------------------------------------------------------------");
            System.out.println("               1. 작업 할당 2. 작업 해제 3. 뒤로가기");
            System.out.println("---------------------------------------------------------------");
            System.out.print("메뉴 선택 > ");
            String index = sc.nextLine();

            switch (index) {
                case "1" -> {
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

                        System.out.print("작업에 할당할 직원의 ID를 입력하세요 : ");
                        long targetId = Long.parseLong(sc.nextLine());
                        Employee target = manager.findById(targetId);

                        if(manager.exists(targetId)){
                            if(target.isWorking()){
                                System.out.println("[ID]: "  + target.getId() + " [이름]: " + target.getName()+"은(는) 이미 작업 중 입니다." );
                            }else{
                                System.out.println(target.startWork());
                            }
                        }else {
                            System.out.println("해당 직원을 찾을 수 없습니다.");
                        }
                    }
                }
                case "2" -> {
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
                        System.out.print("작업 해제할 직원의 ID를 입력하세요 : ");
                        long targetId = Long.parseLong(sc.nextLine());

                        Employee target = manager.findById(targetId);

                        if(manager.exists(targetId)){
                            if(!target.isWorking()){
                                System.out.println("[ID]: "  + target.getId() + " [이름]: " + target.getName()+"은(는) 이미 작업 중이 아닙니다." );
                            }else{
                                System.out.println(target.endWork());
                            }
                        }else {
                            System.out.println("해당 직원을 찾을 수 없습니다.");
                        }
                    }
                }
                case "3" -> {
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

                switch (index) {
                    case "1" -> {
                        for (Employee emp : manager.findAll()) {
                            emp.showInfo();
                        }
                    }
                    case "2" -> {
                        System.out.print("조회할 직원의 ID를 입력하세요: ");
                        long targetId = Long.parseLong(sc.nextLine());
                        if (manager.exists(targetId)) {
                            Employee target = manager.findById(targetId);
                            target.showInfo();
                        } else {
                            System.out.println("해당 ID의 직원을 찾을 수 없습니다.");
                        }
                    }
                    case "3" -> {
                        return;
                    }
                    default -> System.out.println("잘못된 선택입니다.");
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
                        Employee removed = manager.remove(targetId);
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
        System.out.println("                        직원 관리 시스템");
        System.out.println("=============================================================");
        System.out.println("1. 직원등록 | 2. 직원조회 | 3. 직원삭제 | 4. 작업 현황 | 5. 종료");
        System.out.print("메뉴 선택 > ");
    }

    private static Employee createDeveloper(Scanner sc){
        System.out.println("직무 선택 : 1. 풀스택 개발자 | 2. AI 개발자 | 3. 인프라 개발자 | 4. 뒤로 가기");
        System.out.print("메뉴 선택 > ");
        String index = sc.nextLine();

        if(!index.equals("1")&&!index.equals("2")&&!index.equals("3")&&!index.equals("4")){
            System.out.println("잘못된 선택입니다.");
            return null;
        }
        if(index.equals("4")){
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

        switch (index) {
            case "1" -> {
                System.out.print("프론트엔드 프레임워크 : ");
                String frontendFramework = sc.nextLine();
                System.out.print("백엔드 프레임워크 : ");
                String backendFramework = sc.nextLine();
                return new FullStackDeveloper(name, age, email, mainLanguage, frontendFramework, backendFramework);
            }
            case "2" -> {
                System.out.print("전문 필드 : ");
                String mainField = sc.nextLine();
                return new AIDeveloper(name, age, email, mainLanguage, mainField);
            }
            case "3" -> {
                System.out.print("메인 플랫폼 : ");
                String mainPlatform = sc.nextLine();
                return new InfraDeveloper(name, age, email, mainLanguage, mainPlatform);
            }
            default -> {
                return null;
            }
        }
    }
    private static Employee createDesigner(Scanner sc){
        System.out.println("직무 선택 : 1. UI/UX 디자인 | 2. 그래픽 디자이너 | 3. 뒤로 가기");
        System.out.print("메뉴 선택 > ");
        String index = sc.nextLine();

        if(!index.equals("1")&&!index.equals("2")&&!index.equals("3")){
            System.out.println("잘못된 선택입니다.");
            return null;
        }
        if(index.equals("3")){
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

        switch (index) {
            case "1" -> {
                System.out.print("메인 프로토타입 툴 : ");
                String prototypeTool = sc.nextLine();
                return new UIUXDesigner(name, age, email, designTool, prototypeTool);
            }
            case "2" -> {
                System.out.print("메인 그래픽 작업 유형 : ");
                String graphicAssertType = sc.nextLine();
                return new GraphicDesigner(name, age, email, designTool, graphicAssertType);
            }
            default -> {
                return null;
            }
        }
    }

    private static void initializeEmployees(EmployeeManager manager){
        manager.add(new FullStackDeveloper("Finn", 25, "finn1234@gmail.com", "java", "React", "Spring"));
        manager.add(new AIDeveloper("Gildong", 27, "gildong1234@gmail.com", "python", "Computer Vision"));
        manager.add(new InfraDeveloper("Sam",27,"sam1234@gmail.com","java", "AWS"));

        manager.add(new UIUXDesigner("Jun", 32, "jun123@gmail.com", "Figma", "Figma Prototype"));
        manager.add(new GraphicDesigner("Emma", 27, "emma123@gmail.com", "Adobe Illustrator", "Poster"));
    }
}

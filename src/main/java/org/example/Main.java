package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("ЗАПУСК СИСТЕМЫ УПРАВЛЕНИЯ СПУТНИКОВОЙ ГРУППИРОВКОЙ\n");

        ImagingSatellite satellite = new ImagingSatellite("ДЗЗ-1", 1.0, 0.5);

        System.out.println("1. Создан спутник: " + satellite.getName());
        System.out.println("   Разрешение: " + satellite.getResolution() + " м/пиксель");
        System.out.println("   Батарея: " + satellite.getBatteryLevel());
        System.out.println("   Активен? " + satellite.isActive());

        System.out.println("\n2. Пробуем выполнить миссию без активации:");
        satellite.performMission();

        System.out.println("\n3. Активация спутника:");
        boolean activated = satellite.activate();
        System.out.println("   Активация успешна? " + activated);

        System.out.println("\n4. Выполняем миссии:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("   Миссия #" + i + ":");
            satellite.performMission();
            System.out.println("   Всего снимков: " + satellite.getPhotosTaken());
            System.out.println("   Остаток батареи: " + satellite.getBatteryLevel() + "\n");
        }

        System.out.println("\n8. Имитация низкой батареи:");
        satellite.consumeBattery(85.0);
        System.out.println("   Батарея после расхода: " + satellite.getBatteryLevel());
        satellite.performMission();

        System.out.println("\n10. Деактивация спутника:");
        satellite.deActivate();
    }
}
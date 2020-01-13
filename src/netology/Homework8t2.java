/*
Задача 3. Иерархия "Автомобили"

1) Описание:

На этот раз рассмотрим предметную область "Автомобили". Необходимо спроектировать приложение по размещению объявлений о
продаже автомобилей.

Реализуйте иерархию классов автомобилей с помощью наследования. В ней должны быть представлены три группы классов:

- по назначению (грузовые/легковые/пассажирские);
- по типу кузова (седан/универсал/грузовик/автобус);
- по типу топлива (бензиновые, дизельные, гибридные и электрические).

Необходимо с помощью наследования реализовать программу, в которой будет один базовый класс VehicleType, три наследника
базового класса (VehicleTypeByPurpose, VehicleTypeByBodyTypes, VehicleTypeByFuelTypes), в которых будeт определено
значение поля attribute каждой группы типов, и на каждый класс групп типов — по несколько классов, в которых будет
определено конкретное определение типа.

Данный функционал пригодится в случае массовой фильтрации объявлений по какому-то искомому типу.

Также необходимо описать класс VehicleAd:

- с базовым набором полей, состоящим из id объявления, model (модели авто) и трех полей с каждым типом,
- и AdsService, в котором будет осуществляться фильтрация объявлений.
*/



package netology;

public class Homework8t2 {

    public static void main(String[] args) {
        AdsService adsService = new AdsService();
        VehicleAd volvoAd = new VehicleAd(
                "Volvo",
                "123",
                new PassengerType(),
                new SedanType(),
                new PetrolType()
        );

        VehicleAd kamazAd = new VehicleAd(
                "Kamaz",
                "45",
                new TruckType(),
                new PickupType(),
                new DieselType()
        );

        VehicleAd bmwAd = new VehicleAd(
                "BMW",
                "75",
                new CarType(),
                new SedanType(),
                new PetrolType()
        );

        adsService.setAdList(new VehicleAd[] {volvoAd, kamazAd, bmwAd});

        System.out.println("Фильтр по пассажирским авто:\n");
        adsService.filterByVehicleTypeByPurpose(new PassengerType());

        System.out.println("\nФильтр по грузовым авто:\n");
        adsService.filterByVehicleTypeByPurpose(new TruckType());

        System.out.println("\nФильтр по авто с бензиновым двигателем:\n");
        adsService.filterByVehicleTypeByFuelTypes(new PetrolType());

    }

    public enum VehicleTypeEnum {
        TRUCK,
        CAR,
        PASSENGER,
        SEDAN,
        WAGON,
        PICKUP,
        BUS,
        PETROL,
        DIESEL,
        HYBRID,
        ELECTRIC
    }

    public static class VehicleType {

        private String attribute = "";

        public VehicleType(String attribute) {
            this.attribute = attribute;
        }

        public String getAttributeOfType() {
            return attribute;
        }

        public String getTypeName() {
            return "Some vehicle type name";
        }
    }

    public static class VehicleTypeByPurpose extends VehicleType {

        public VehicleTypeByPurpose() {
            super("Vehicle type by purpose");
        }

        @Override
        public boolean equals(Object object) {

            if (object == null || getClass() != object.getClass()) return false;

            VehicleTypeByPurpose that = (VehicleTypeByPurpose) object;

            return this.getAttributeOfType() != null && getAttributeOfType().equals(that.getAttributeOfType());

        }
    }

    public static class VehicleTypeByBodyTypes extends VehicleType {

        public VehicleTypeByBodyTypes() {
            super("Vehicle type by body type");
        }

        @Override
        public boolean equals(Object object) {

            if (object == null || getClass() != object.getClass()) return false;

            VehicleTypeByBodyTypes that = (VehicleTypeByBodyTypes) object;

            return this.getAttributeOfType() != null && getAttributeOfType().equals(that.getAttributeOfType());

        }
    }

    public static class VehicleTypeByFuelTypes extends VehicleType {

        public VehicleTypeByFuelTypes() {
            super("Vehicle type by fuel type");
        }

        @Override
        public boolean equals(Object object) {

            if (object == null || getClass() != object.getClass()) return false;

            VehicleTypeByFuelTypes that = (VehicleTypeByFuelTypes) object;

            return this.getAttributeOfType() != null && getAttributeOfType().equals(that.getAttributeOfType());

        }
    }

    public static class TruckType extends VehicleTypeByPurpose {

        @Override
        public String getTypeName() {
            return VehicleTypeEnum.TRUCK.name();
        }
    }

    public static class CarType extends VehicleTypeByPurpose {

        @Override
        public String getTypeName() {
            return VehicleTypeEnum.CAR.name();
        }
    }

    public static class PassengerType extends VehicleTypeByPurpose {

        @Override
        public String getTypeName() {
            return VehicleTypeEnum.PASSENGER.name();
        }
    }

    public static class SedanType extends VehicleTypeByBodyTypes {

        @Override
        public String getTypeName() {
            return VehicleTypeEnum.SEDAN.name();
        }
    }

    public static class WagonType extends VehicleTypeByBodyTypes {

        @Override
        public String getTypeName() {
            return VehicleTypeEnum.WAGON.name();
        }
    }

    public static class PickupType extends VehicleTypeByBodyTypes {

        @Override
        public String getTypeName() {
            return VehicleTypeEnum.PICKUP.name();
        }
    }

    public static class BusType extends VehicleTypeByBodyTypes {

        @Override
        public String getTypeName() {
            return VehicleTypeEnum.BUS.name();
        }
    }

    public static class PetrolType extends VehicleTypeByFuelTypes {

        @Override
        public String getTypeName() {
            return VehicleTypeEnum.PETROL.name();
        }
    }

    public static class DieselType extends VehicleTypeByFuelTypes {

        @Override
        public String getTypeName() {
            return VehicleTypeEnum.DIESEL.name();
        }
    }

    public static class HybridType extends VehicleTypeByFuelTypes {

        @Override
        public String getTypeName() {
            return VehicleTypeEnum.HYBRID.name();
        }
    }

    public static class ElectricType extends VehicleTypeByFuelTypes {

        @Override
        public String getTypeName() {
            return VehicleTypeEnum.ELECTRIC.name();
        }
    }

    public static class VehicleAd {
        private String model;
        private String id;
        private VehicleTypeByPurpose vehicleTypeByPurpose;
        private VehicleTypeByBodyTypes vehicleTypeByBodyTypes;
        private VehicleTypeByFuelTypes vehicleTypeByFuelTypes;

        public VehicleAd(
                String model,
                String id,
                VehicleTypeByPurpose vehicleTypeByPurpose,
                VehicleTypeByBodyTypes vehicleTypeByBodyTypes,
                VehicleTypeByFuelTypes vehicleTypeByFuelTypes
        ) {
            this.model = model;
            this.id = id;
            this.vehicleTypeByPurpose = vehicleTypeByPurpose;
            this.vehicleTypeByBodyTypes = vehicleTypeByBodyTypes;
            this.vehicleTypeByFuelTypes = vehicleTypeByFuelTypes;
        }

        //for creating new Car
        public VehicleAd(String model) {
            this.model = model;
        }

        public VehicleTypeByPurpose getVehicleTypeByPurpose() {
            return vehicleTypeByPurpose;
        }

        public VehicleTypeByBodyTypes getVehicleTypeByBodyTypes() {
            return vehicleTypeByBodyTypes;
        }

        public VehicleTypeByFuelTypes getVehicleTypeByFuelTypes() {
            return vehicleTypeByFuelTypes;
        }

        public String getModel() {
            return model;
        }

        public String getId() {
            return id;
        }

        public String toString(){
            return this.model;
        }
    }

    public static class AdsService {
        private VehicleAd[] adList;

        public void setAdList(VehicleAd[] adList) {
            this.adList = adList;
        }

        public void filterByVehicleTypeByPurpose(VehicleTypeByPurpose vehicleType) {
            for (VehicleAd ad : adList) {
                if (ad.getVehicleTypeByPurpose().equals(vehicleType)) {
                    System.out.println("Объявление № " +
                                        ad.getId() +
                                        " подходит под данный фильтр с атрибутом: тип авто - " +
                                        vehicleType.getTypeName() +
                                        ", атрибут фильтра " +
                                        vehicleType.getAttributeOfType()
                    );
                } else {
                    System.out.println("Объявление № " +
                                        ad.getId() +
                                        " не прошло фильтр: тип авто - " +
                                        vehicleType.getTypeName() +
                                        ", критерий- " +
                                        vehicleType.getAttributeOfType() +
                                        ", так как имеет тип авто " +
                                        ad.getVehicleTypeByPurpose().getTypeName()
                    );
                }
            }
        }

        public void filterByVehicleTypeByBodyTypes(VehicleTypeByBodyTypes vehicleType) {
            for (VehicleAd ad : adList) {
                if (ad.getVehicleTypeByBodyTypes().equals(vehicleType)) {
                    System.out.println("Объявление № " +
                                        ad.getId() +
                                        " подходит под данный фильтр с атрибутом: тип авто - " +
                                        vehicleType.getTypeName() +
                                        ", атрибут фильтра " +
                                        vehicleType.getAttributeOfType()
                    );
                } else {
                    System.out.println("Объявление № " +
                                        ad.getId() +
                                        " не прошло фильтр: тип авто - " +
                                        vehicleType.getTypeName() +
                                        ", критерий- " +
                                        vehicleType.getAttributeOfType() +
                                        ", так как имеет тип авто " +
                                        ad.getVehicleTypeByBodyTypes().getTypeName()
                    );
                }
            }
        }

        public void filterByVehicleTypeByFuelTypes(VehicleTypeByFuelTypes vehicleType) {
            for (VehicleAd ad : adList) {
                if (ad.getVehicleTypeByFuelTypes().equals(vehicleType)) {
                    System.out.println("Объявление № " +
                                        ad.getId() +
                                        " подходит под данный фильтр с атрибутом: тип авто - " +
                                        vehicleType.getTypeName() +
                                        ", атрибут фильтра " +
                                        vehicleType.getAttributeOfType()
                    );
                } else {
                    System.out.println("Объявление № " +
                                        ad.getId() +
                                        " не прошло фильтр: тип авто - " +
                                        vehicleType.getTypeName() +
                                        ", критерий- " +
                                        vehicleType.getAttributeOfType() +
                                        ", так как имеет тип авто " +
                                        ad.getVehicleTypeByFuelTypes().getTypeName()
                    );
                }
            }
        }

    }
}

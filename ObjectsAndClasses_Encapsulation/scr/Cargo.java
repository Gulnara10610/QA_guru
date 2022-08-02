public class Cargo {

    private final int weight;
    private final String deliveryAddress;
    private final boolean propertyIsFlip;
    private final String registrationNumber;
    private final boolean isFragileCargo;
    private String items;
    private final Dimensions dimensions;

    public Cargo(Dimensions dimensions, int weight, String deliveryAddress, boolean propertyIsFlip, String registrationNumber,
                 boolean isFragileCargo) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.propertyIsFlip = propertyIsFlip;
        this.registrationNumber = registrationNumber;
        this.isFragileCargo = isFragileCargo;
    }


    public Cargo setDimensions(Dimensions dimensions) {
        return new Cargo(dimensions, weight, deliveryAddress, propertyIsFlip, registrationNumber, isFragileCargo);
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public int getWeight() {
        return weight;
    }

    public Cargo setWeight(int weight) {
        return new Cargo(dimensions, weight, deliveryAddress, propertyIsFlip, registrationNumber, isFragileCargo);
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public Cargo setDeliveryAddress(String deliveryAddress) {
        return new Cargo(dimensions, weight, deliveryAddress, propertyIsFlip, registrationNumber, isFragileCargo);
    }

    public boolean isPropertyIsFlip() {
        return propertyIsFlip;
    }

    public Cargo setPropertyIsFlip(boolean propertyIsFlip) {
        return new Cargo(dimensions, weight, deliveryAddress, propertyIsFlip, registrationNumber, isFragileCargo);
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Cargo setRegistrationNumber(String registrationNumber) {
        return new Cargo(dimensions, weight, deliveryAddress, propertyIsFlip, registrationNumber, isFragileCargo);
    }

    public boolean isFragileCargo() {
        return isFragileCargo;
    }

    public Cargo setFragileCargo(boolean fragileCargo) {
        return new Cargo(dimensions, weight, deliveryAddress, propertyIsFlip, registrationNumber, isFragileCargo);
    }

    public String toString() {
        return "Габариты " + "\n" + "Вес" + weight + "\n" + "Адрес доставки : " + deliveryAddress + "\n" + "Можно переворачивать - " + propertyIsFlip + "\n" + "Регистрационный номер " + registrationNumber + "\n" + " Хрупкий " + isFragileCargo + "\n";
    }
}

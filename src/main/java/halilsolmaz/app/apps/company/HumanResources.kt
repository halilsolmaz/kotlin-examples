package halilsolmaz.app.apps.company

class HumanResources {
    fun payInsurance(employee: Employee)
    {
        println("Name:${employee.name}, citizienId:${employee.citizienId}, address:${employee.address}")
        println("Insurance Payment:${employee.calculateInsurancePayment()}")
    }
}
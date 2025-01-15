import { Supplier } from "./Supplier";
export class Warehouse {
    warehouseId: number
    supplierId:string
    warehouseName:string
    location: string
    capacity:number

    constructor(warehouseId:number, supplierId:string, warehouseName: string, location:string, capacity:number){
        this.warehouseId=warehouseId
        this.supplierId = supplierId
        this.warehouseName = warehouseName
        this.location = location
        this.capacity = capacity
    }

    displayInfo(){
        // console.log(`Warehouse ID: ${this.warehouseId} \nSupplier ID: ${this.supplierId} \nCapacity: ${this.capacity}`)
    console.log(`Warehouse ID: ${this.warehouseId}`)
    console.log(`Supplier ID: ${this.supplierId}`)
    console.log(`Capacity: ${this.capacity}`)
    
    }
}

// const warehouse = new Warehouse(1,"1","ware1","texas",2)
// warehouse.displayInfo()
import { Pipe, PipeTransform } from "@angular/core";
import { Operation } from "../model/opetaion.enum";

@Pipe({
  name: 'operation'
})
export class OperationPipe implements PipeTransform {

  transform(value: any, ...args: any[]) {
    if (value) {
      return value === "DEPOSIT" //FIXME: ????
        ? Operation.DEPOSIT.toString()
        : Operation.WITHDRAW.toString();
    }

    return value;
  }

}

import { Pipe, PipeTransform } from "@angular/core";

@Pipe({name: 'agency'})
export class AgencyPipe implements PipeTransform {
    
    transform(value: any, ...args: any[]) {

        if (value) {
            return String(value).padStart(4, '0');
        }

        return value;

    }
    
}
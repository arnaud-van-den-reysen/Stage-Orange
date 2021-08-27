export interface Product {
    id: number;
    jdoc: Jdoc;
}

export interface Jdoc {
    idprod: number;
    nameprod: string;
    description: string;
}
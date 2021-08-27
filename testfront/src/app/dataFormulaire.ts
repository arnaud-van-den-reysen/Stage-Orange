/**
 * @property id: number,
 * @property dataFormulaireJSON: DataFormulaireJSON
 */
 export interface DataFormulaire {
    id: number;
    dataFormulaireJSON: DataFormulaireJSON;
}

/**
 * @property id: number,
 * @property name: String,
 * @property formulaire: produitFormulaire[]
 */
export interface DataFormulaireJSON {
    id: number;
    name: String;
    produitFormulaire: produitFormulaire[];
}

/**
 * @property type: String,
 * @property source: Source,
 * @property destination: Destination,
 * @property autreType: String
 */
export interface produitFormulaire {
    type: String;
    source: Source;
    destination: Destination;
    autreType: String;
}

/**
 * @property hostname: String,
 * @property login: String,
 * @property pwd: String
 */
export interface Source {
    hostname: String;
    login: String;
    pwd: String;
}

/**
 * @property hostname: String,
 * @property login: String,
 * @property pwd: String
 */
export interface Destination {
    hostname: String;
    login: String;
    pwd: String;
}
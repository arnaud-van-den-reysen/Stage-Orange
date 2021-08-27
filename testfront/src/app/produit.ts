/**
 * @property id: number,
 * @property formulaireJSON: Formulaire
 */
export interface Produit {
    id: number;
    formulaireJSON: Formulaire;
}

/**
 * @property id: number,
 * @property name: String,
 * @property formulaire: String[]
 */
export interface Formulaire {
    id: number;
    name: String;
    formulaire: String[];
}
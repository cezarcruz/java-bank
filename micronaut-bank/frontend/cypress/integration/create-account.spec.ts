describe('testando a criacao de contas', () => {

    beforeEach(() => {
      cy.visit('/backoffice/cria-conta');
    });
  
    it('procura pelos elementos em tela', () => {

        cy.get('#agenciaInput')
            .should('be.enabled');
        
        cy.get('#criaAgenciaBtn')
            .should('be.disabled');

    });

    it('insere número da agencia', () => {
        cy.get('#agenciaInput')
            .focus().type('100');
        
        cy.get('#criaAgenciaBtn')
            .should('be.enabled');

        cy.get('#agenciaInput')
            .should(($input) => {
                const val = $input.val()
                expect(val).eq('100');
            });
    });

    it('cria uma nova conta', () => {
        cy.get('#agenciaInput')
            .focus().type('100');
        
        cy.get('#criaAgenciaBtn')
            .should('be.enabled');
        
        cy.get('#criaAgenciaBtn')
            .click();

        cy.get('#dadosConta')
            .get('p');
    });

  });
  
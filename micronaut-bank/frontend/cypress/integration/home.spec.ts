describe('testando a home page', () => {

  beforeEach(() => {
    cy.visit('/');
  })

  it('acessa home page', () => {    
    cy.title()
      .should((title) => {
        expect(title).eq('Frontend');
      });
  });

  it('verifica texto na pagina', () => {
    cy.contains('h1', 'Olá');
  });

})

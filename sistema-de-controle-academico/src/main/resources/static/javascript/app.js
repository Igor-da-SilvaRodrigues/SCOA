//Classe que mantem todas as tabs funcionando corretamente
class Tabs{
    tabs;
    segments;
    tab_ativa
    constructor(){
        this.tabs = $(".tabular.menu .item.tab.link");
        this.segments = $(".attached.segment .ui.tab");
        if (this.tabs === undefined){//impede a classe de mudar qualquer coisa no documento se nao houverem tabs no documento
            return;
        }

        this.tabs.toArray().forEach( tab => {
            tab.onclick = (event) => { 
                this.ativar_tab(tab);
            };
        });
    
    
    }
    
    ativar_tab(tab){
        this.desativar_tabs(this.tabs);
        tab.classList.add("active");
        this.tab_ativa = tab;
        this.ativar_segmento_de_data(tab.getAttribute('data-tab'));
    }
    
    desativar_tabs(tab){
        for (let i = 0; i < tab.length; i += 1){
            tab[i].classList.remove("active");
        }
        this.tab_ativa = undefined;
    }

    ativar_segmento_de_data(data){
        if (this.segments === undefined){return;}

        this.segments.toArray().forEach( segment => {
            if (segment.getAttribute('data-tab') == data){
                segment.style.display = "flex";
            }else{
                segment.style.display = "none";
            }
        });
    }

}

class Linhas{
    linhas;
    linha_ativa;
    constructor(){
        this.linhas = $('.ui.celled.table tbody tr ');

        if (this.linhas == undefined){//impede a classe de mudar qualquer coisa no documento se nao houverem linhas em tabelas no documento
            return;
        }

        this.linhas.toArray().forEach( linha => {
            linha.onclick = (event) => { 
                this.ativar_linha(linha);
            };
        });
    
    }

    ativar_linha(linha){
        this.desativar_linhas(this.linhas);
        linha.classList.add('active');
        this.linha_ativa = linha;
    }

    desativar_linhas(linhas){
        linhas.toArray().forEach( linha => {
            linha.classList.remove('active');
        });
        this.linha_ativa = undefined;
    }
}

function validar_form_artigo(){
    $('.ui.form#cadastro_artigo')
  .form({
    fields: {
      titulo     : 'empty',
      anoPublicacao   : 'empty',
      palavrasChave : 'empty',
      autor : 'empty',
      editora   : 'empty'
    }
  })
;

    $('.ui.form#cadastro_artigo')
    .form({
    fields: {
        titulo: {
        identifier: 'titulo',
        rules: [
            {
            type   : 'empty',
            prompt : 'O artigo deve ter um titulo.'
            }
        ]
        },
        anoPublicacao: {
        identifier: 'anoPublicacao',
        rules: [
            {
            type   : 'empty',
            prompt : 'O artigo deve ter um ano de publicação.'
            }
        ]
        },
        palavrasChave: {
        identifier: 'palavrasChave',
        rules: [
            {
            type   : 'empty',
            prompt : 'O artigo deve ter pelo menos uma palavra chave'
            }
        ]
        },
        autor: {
        identifier: 'autor',
        rules: [
            {
            type   : 'empty',
            prompt : 'O artigo deve ter um autor'
            }
        ]
        },
        editora: {
        identifier: 'editora',
        rules: [
            {
            type   : 'empty',
            prompt : 'O artigo deve ter uma editora'
            }
        ]
        }
    }
    })
    ;

}

// Colocar aqui tudo que precisar carregar depois da pagina
window.onload = function(){
    let tabs = new Tabs();
    let linhas = new Linhas();
    validar_form_artigo();

};
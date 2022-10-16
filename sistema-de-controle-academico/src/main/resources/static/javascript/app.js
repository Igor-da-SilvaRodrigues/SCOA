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

// Colocar aqui tudo que precisar carregar depois da pagina
window.onload = function(){
    let tabs = new Tabs();
    let linhas = new Linhas();
};
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

//Permite os campos alertarem ao usuario sobre entradas invalidas.
function validar_form_artigo(){
    $('.ui.form#cadastro_artigo')
    .form({
    fields: {
        titulo: {
            identifier: 'titulo',
            rules: [
                {
                    type: 'empty',
                    prompt: 'O artigo deve ter um titulo'
                },
                {
                    type: 'maxLength[255]',
                    prompt: 'O titulo deve ter no maximo 255 caracteres'
                }
            ]
        },
        anoPublicacao: {
            identifier: 'anoPublicacao',
            rules: [
                {
                    type: 'empty',
                    prompt: 'O artigo deve ter um ano de publicacao'
                }
            ]
        },
        palavrasChave: {
            identifier: 'palavrasChave',
            rules: [
                {
                    type: 'empty',
                    prompt: 'O artigo deve ter pelo menos uma palavra chave'
                },
                {
                    type: 'maxLength[511]',
                    prompt: 'As palavras chave devem ter no maximo um total de 511 caracteres'
                }
            ]
        },
        autor: {
            identifier: 'autor',
            rules: [
                {
                    type: 'empty',
                    prompt: 'O artigo deve ter um autor'
                },
                {
                    type: 'maxLength[127]',
                    prompt: 'O autor deve ter no maximo 127 caracteres'
                }
            ]
        },
        editora: {
            identifier: 'editora',
            rules: [
                {
                    type: 'empty',
                    prompt: 'O artigo deve ter uma editora'
                },
                {
                    type: 'maxLength[127]',
                    prompt: 'A editora deve ter no maximo 127 caracteres'
                }
            ]
        }
    }
    })
    ;

}

function validar_form_filme(){
    $('.ui.form#cadastro_filme')
    .form({
    fields: {
        titulo: {
            identifier: 'titulo',
            rules: [
                {
                    type: 'empty',
                    prompt: 'O filme deve ter um titulo'
                },
                {
                    type: 'maxLength[255]',
                    prompt: 'O titulo deve ter no maximo 255 caracteres'
                }
            ]
        },
        anoPublicacao: {
            identifier: 'anoPublicacao',
            rules: [
                {
                    type: 'empty',
                    prompt: 'O filme deve ter um ano de publicacao'
                }
            ]
        },
        palavrasChave: {
            identifier: 'palavrasChave',
            rules: [
                {
                    type: 'empty',
                    prompt: 'O filme deve ter pelo menos uma palavra chave'
                },
                {
                    type: 'maxLength[511]',
                    prompt: 'As palavras chave devem ter no maximo um total de 511 caracteres'
                }
            ]
        },
        diretores: {
            identifier: 'diretores',
            rules: [
                {
                    type: 'empty',
                    prompt: 'O filme deve ter pelo menos um diretor'
                },
                {
                    type: 'maxLength[255]',
                    prompt: 'Os diretores devem ter no total um maximo de 255 caracteres'
                }
            ]
        },
        distribuidor: {
            identifier: 'distribuidor',
            rules: [
                {
                    type: 'empty',
                    prompt: 'O filme deve ter um distribuidor'
                },
                {
                    type: 'maxLength[127]',
                    prompt: 'O distribuidor deve ter no maximo 127 caracteres'
                }
            ]
        },
        genero: {
            identifier: 'genero',
            rules: [
                {
                    type: 'empty',
                    prompt: 'O filme deve ter um genero'
                },
                {
                    type: 'maxLength[127]',
                    prompt: 'O genero deve ter no maximo 127 caracteres'
                }
            ]
        },
        sinopse: {
            identifier: 'sinopse',
            rules: [
                {
                    type: 'empty',
                    prompt: 'O filme deve ter uma sinopse'
                },
                {
                    type: 'maxLength[1023]',
                    prompt: 'A sinopse deve ter no maximo 1023 caracteres'
                }
            ]
        },
        duracao: {
            identifier: 'duracao',
            rules: [
                {
                    type: 'empty',
                    prompt: 'O filme deve ter uma duracao'
                }
            ]
        }
    }
    })
    ;
}

function validar_form_jornal(){
    $('.ui.form#cadastro_jornal')
    .form({
    fields: {
        titulo: {
            identifier: 'titulo',
            rules: [
                {
                    type: 'empty',
                    prompt: 'O jornal deve ter um titulo'
                },
                {
                    type: 'maxLength[255]',
                    prompt: 'O titulo deve ter no maximo 255 caracteres'
                }
            ]
        },
        anoPublicacao: {
            identifier: 'anoPublicacao',
            rules: [
                {
                    type: 'empty',
                    prompt: 'O jornal deve ter um ano de publicacao'
                }
            ]
        },
        palavrasChave: {
            identifier: 'palavrasChave',
            rules: [
                {
                    type: 'empty',
                    prompt: 'O jornal deve ter pelo menos uma palavra chave'
                },
                {
                    type: 'maxLength[511]',
                    prompt: 'As palavras chave devem ter no maximo um total de 511 caracteres'
                }
            ]
        },
        manchete: {
            identifier: 'manchete',
            rules: [
                {
                    type: 'empty',
                    prompt: 'O jornal deve ter uma manchete'
                },
                {
                    type: 'maxLength[255]',
                    prompt: 'A manchete deve ter no maximo 255 caracteres'
                }
            ]
        },
        quantidadePaginas: {
            identifier: 'quantidadePaginas',
            rules: [
                {
                    type: 'empty',
                    prompt: 'Por favor especifique quantas paginas tem o jornal'
                }
            ]
        }
    }
    })
    ;
}

function validar_form_livro(){
    $('.ui.form#cadastro_livro')
    .form({
    fields: {
        titulo: {
            identifier: 'titulo',
            rules: [
                {
                    type: 'empty',
                    prompt: 'O livro deve ter um titulo'
                },
                {
                    type: 'maxLength[255]',
                    prompt: 'O titulo deve ter no maximo 255 caracteres'
                }
            ]
        },
        anoPublicacao: {
            identifier: 'anoPublicacao',
            rules: [
                {
                    type: 'empty',
                    prompt: 'O livro deve ter um ano de publicacao'
                }
            ]
        },
        palavrasChave: {
            identifier: 'palavrasChave',
            rules: [
                {
                    type: 'empty',
                    prompt: 'O livro deve ter pelo menos uma palavra chave'
                },
                {
                    type: 'maxLength[511]',
                    prompt: 'As palavras chave devem ter no maximo um total de 511 caracteres'
                }
            ]
        },
        autor: {
            identifier: 'autor',
            rules: [
                {
                    type: 'empty',
                    prompt: 'O livro deve ter um autor'
                },
                {
                    type: 'maxLength[127]',
                    prompt: 'A autor deve ter no maximo 127 caracteres'
                }
            ]
        },
        quantidadePaginas: {
            identifier: 'quantidadePaginas',
            rules: [
                {
                    type: 'empty',
                    prompt: 'Por favor especifique quantas paginas tem o livro'
                }
            ]
        },
        sinopse: {
            identifier: 'sinopse',
            rules: [
                {
                    type: 'empty',
                    prompt: 'O livro deve ter uma sinopse'
                },
                {
                    type: 'maxLength[1023]',
                    prompt: 'A sinopse deve ter no maximo 1023 caracteres'
                }
            ]
        },
        ISBN: {
            identifier: 'ISBN',
            rules: [
                {
                    type: 'empty',
                    prompt: 'O livro deve ter uma ISBN'
                },
                {
                    type: 'maxLength[127]',
                    prompt: 'A ISBN deve ter no maximo 127 caracteres'
                }
            ]
        },
        editora: {
            identifier: 'editora',
            rules: [
                {
                    type: 'empty',
                    prompt: 'O livro deve ter uma editora'
                },
                {
                    type: 'maxLength[127]',
                    prompt: 'A editora deve ter no maximo 127 caracteres'
                }
            ]
        }
    }
    })
    ;
}

function validar_forms(){
    validar_form_artigo();
    validar_form_filme();
    validar_form_jornal();
    validar_form_livro();
}

function delete_obra(id){
    let delete_request = new XMLHttpRequest();
    if (!confirm("Você tem certeza que deseja remover este item do banco de dados?")) return;
    delete_request.open("DELETE", 'http://localhost:8080/biblioteca/obra/delete/'+id);
    
    delete_request.onreadystatechange = function() { 
    if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
        window.location.reload();    
    }
};
    
    delete_request.send();
    
}

// Colocar aqui tudo que precisar carregar depois da pagina
window.onload = function(){
    let tabs = new Tabs();
    let linhas = new Linhas();
    validar_forms();

};
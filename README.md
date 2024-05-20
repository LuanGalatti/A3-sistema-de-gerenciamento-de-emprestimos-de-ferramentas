Requisitos funcionais do sistema:
1-> RF001 - O sistema deve permitir o registro do nome, marca, custo de aquisição da ferramenta;
2-> RF002 - O sistema deve permitir o registro do nome e o telefone do cliente;
3-> RF003 - O sistema deve permitir o registro do empréstimo de uma ou mais pecas para um amigo marcando a data de entrega e a data de devolução;
4-> RF004 - O sistema deve ter um relatório de ferramentas e o quanto ele gastou;
5-> RF005 - O sistema deve mostrar os empréstimos ativos e outros empréstimos realizados;
6-> RF006 -	O sistema deve mostrar quem realizou a maior quantidade de empréstimos;
7-> RF007 -	O sistema deve mostrar quem ainda não devolveu a ferramenta;
8-> RF008 - O sistema deve mostrar se alguém ainda não devolveu uma ferramenta ao requisitar um novo empréstimo.

Requisitos não funcionais do sistema:
1-> RNF001 - Desempenho do sistema:
            * Tempo de resposta: equivalente a 2s em solicitações de empréstimo e devoluções;
            * O sistema deve suportar até 50 usuários simultaneamente sem causar erro no sistema;
            * O sistema deve suportar até 100 registros de empréstimo simultaneamente sem causar erro no sistema.
2-> RNF002 - Segurança:
            * Login e Registro: Apenas usuários autenticados possam acessar funcionalidades de empréstimo e devolução de ferramentas;
            * Proteção de Dados: Dados como informações pessoais e detalhes de contato dos clientes devem ser protegidos durante o armazenamento e a permanência do usuário no site;
3-> RNF003 - Usabilidade:
            * Interface Intuitiva: A interface do usuário deve ser fácil de usar e de se compreender, permitindo que usuários sem conhecimento na área façam empréstimos e devoluções sem dificuldades;
            * Acessibilidade : individuos devem ter um fácil acesso para pessoas com dificuldade de compreensão ou alguma deficiência.
4-> RNF004 - Confiabilidade:
            * Disponibilidade de Funcionamento: o sistema deve estar funcionando corretamente em 100% do tempo, possibilitanto o acesso do usuário a todo momento;
            * Prevenção contra falhas: se o sistema der falha, o funcionamento deve ser reconstituido em até 10 minutos após a falha e retomar suas atividades;
            * Salvamento de Dados (Backup): o sistema deve salvar as movimentações do usuário a cada operação realizada pelo mesmo. Armazenando-as em um local seguro;
5-> RNF005 - Manutenção:

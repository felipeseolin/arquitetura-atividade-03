<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <title>Gerenciamento de Cliente</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>

<body>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <!-- Brand -->
    <a class="navbar-brand" href="#">App</a>

    <!-- Toggler/collapsibe Button -->
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>

    <!-- Navbar links -->
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/cliente">Cliente</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/pais">Pais</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container-fluid mt-3">
    <div class="card">
        <div class="card-header">
            <h3>Gerenciamento de Clientes</h3>
        </div>
        <div class="card-body">
            <div>

                <#if ClienteAtual??>
                <form method="post" action="/cliente/alterar">
                    <div class="float-right mt-1 mb-1">
                        <input type="submit" class="btn btn-warning" value="Alterar"></input>
                    </div>
                    <#else>
                    <form method="post" action="/cliente/criar">
                        <div class="float-right mt-1 mb-1">
                            <input type="submit" class="btn btn-primary" value="Criar"></input>
                        </div>
                    </#if>

                    <input type="hidden" name="id" value="${(clienteAtual.id)!}"></input>

                    <div class="form-group">
                        <label for="nome">Nome:</label>
                        <input value="${(clienteAtual.nome)!}" name="nome" type="text" class="form-control" id="nome" placeholder="Fulano">
                    </div>
                    <div class="form-group">
                        <label for="nome">Idade:</label>
                        <input value="${(clienteAtual.idade)!}" name="idade" type="number" class="form-control" id="idade" placeholder="12">
                    </div>
                    <div class="form-group">
                        <label for="nome">Telefone:</label>
                        <input value="${(clienteAtual.telefone)!}" name="telefone" type="text" class="form-control" id="telefone" placeholder="123456">
                    </div>
                    <div class="form-group">
                        <label for="nome">Limite de crédito:</label>
                        <input value="${(clienteAtual.limiteCredito)!}" name="limiteCredito" type="text" class="form-control" id="limiteCredito" placeholder="20.35">
                    </div>
                    <div class="form-group">
                        <label for="nome">Países:</label>
                        <select name="paisId" id="paisId" class="form-control">
                            <option value="" disabled selected>Selecione um país...</option>
                            <option value="${listaPaises.id}">${listaPaises.nome}</option>
                        </select>
                    </div>
                </form>
            </div>

            <div class="mt-3">
                <table class="table">
                    <thead class="thead-dark">
                    <tr>
                        <th>Nome</th>
                        <th>Idade</th>
                        <th>Telefone</th>
                        <th>Limite de Credito</th>
                        <th>País</th>
                        <th>Ações</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list listaClientes as cliente>
                    <tr>
                        <td>${cliente.nome}</td>
                        <td>${cliente.idade}</td>
                        <td>${cliente.telefone}</td>
                        <td>${cliente.limiteCredito}</td>
                        <td>${cliente.pais.nome}</td>
                        <td>
                            <a href="/cliente/preparaAlterar/${cliente.id}" class="btn btn-warning">Alterar</a>
                            <a href="/cliente/apagar/${cliente.id}" class="btn btn-danger">Excluir</a>
                        </td>
                    </tr>
                    </#list>

                    </tbody>
                </table>
            </div>
        </div>
        <div class="card-footer"></div>
    </div>
</div>


<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>

</html>
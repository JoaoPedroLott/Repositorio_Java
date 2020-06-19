<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<head>
	<title>Registro - Adventure Books - Seu lugar é aqui!</title>

	<!-- Meta -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">

	<!-- Favicon -->
	<link rel="shortcut icon" href="favicon.ico">

	<!-- Web Fonts -->
	<link rel='stylesheet' type='text/css' href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600&amp;subset=cyrillic,latin'>

	<!-- CSS Global Compulsory -->
	<link rel="stylesheet" href="assets/plugins/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/shop.style.css">

	<!-- CSS Header and Footer -->
	<link rel="stylesheet" href="assets/css/headers/header-v5.css">
	<link rel="stylesheet" href="assets/css/footers/footer-v4.css">

	<!-- CSS Implementing Plugins -->
	<link rel="stylesheet" href="assets/plugins/animate.css">
	<link rel="stylesheet" href="assets/plugins/line-icons/line-icons.css">
	<link rel="stylesheet" href="assets/plugins/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="assets/plugins/scrollbar/css/jquery.mCustomScrollbar.css">

	<!-- CSS Page Styles -->
	<link rel="stylesheet" href="assets/css/pages/log-reg-v3.css">

	<!-- Style Switcher -->
	<link rel="stylesheet" href="assets/css/plugins/style-switcher.css">

	<!-- CSS Theme -->
	<link rel="stylesheet" href="assets/css/theme-colors/brown.css" id="style_color">

	<!-- CSS Customization -->
	<link rel="stylesheet" href="assets/css/custom.css">
</head>

<body class="header-fixed">

	<div class="wrapper">
		 <!--=== Header v5 ===-->   
    <div class="header-v5 header-static">
        <!-- Topbar v3 -->
        <div class="topbar-v3">

            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <!-- Topbar Navigation -->
                      
                    </div>
                    <div class="col-sm-6">
                        <ul class="list-inline right-topbar pull-right">
                            <li><a href="shop-ui-login.jsp">Login</a> | <a href="shop-ui-register.jsp">Registro</a></li>
							<li><a href="shop-ui-add-to-cart.jsp">Carrinho (0)</a></li>
                        </ul>
                    </div>
                </div>
            </div><!--/container-->
        </div>
        <!-- End Topbar v3 -->

        <!-- Navbar -->
        <div class="navbar navbar-default mega-menu" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    
                    <a class="navbar-brand" href="index.jsp">
                        <img id="logo-header" src="assets/img/logo.png" alt="Logo">
                    </a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse navbar-responsive-collapse ">
                   
				<div class="col-md-4">
                    <!-- Nav Menu -->
                    <ul class="nav navbar-nav">
                        <!-- Pages -->
                        <li class="dropdown">
                            <a href="javascript:void(0);" class="dropdown-toggle" data-hover="dropdown" data-toggle="dropdown">
                                Home
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="shop-ui-login.jsp">Login</a></li>
                                <li><a href="shop-ui-register.jsp">Registro</a></li>
                            </ul>
                        </li>
                        <!-- End Pages -->

                        <!--Books -->
                        <li class="dropdown">
                            <a href="javascript:void(0);" class="dropdown-toggle" data-hover="dropdown" data-toggle="dropdown" data-delay="1000">
                                Livros
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Produtos</a></li>
                            </ul>
                        </li>
                        <!--Books-->
						 <!--about -->
                        <li>
                            <a href="javascript:void(0);" class="dropdown-toggle" data-hover="dropdown" data-toggle="dropdown" data-delay="1000">
                               Sobre
                            </a>
                         </li>
                        <!--about-->
                    </ul>
					</div>
                    <!-- End Nav Menu -->
                </div>
            </div>    
        </div>            
        <!-- End Navbar -->
    </div>
    <!--=== End Header v5 ===-->
		<!--=== Breadcrumbs v4 ===-->
		<div class="breadcrumbs-v4">
			<div class="container">
				<h1>Adventure<span class="shop-green"> Books</span></h1>
				<ul class="breadcrumb-v4-in">
					<li><a href="index.jsp">Home</a></li>
					<li><a href="">Produtos</a></li>
					<li class="active">Log In</li>
				</ul>
			</div><!--/end container-->
		</div>
		<!--=== End Breadcrumbs v4 ===-->

		<!--=== Registre ===-->
		<div class="log-reg-v3 content-md margin-bottom-30">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
					<img src="assets/img/nerditup.png">
					<h2 class="welcome-title text-center">Bem vindo à  <span class="shop-green">ADVENTURE BOOKS</span></h2>
						<p class="text-center">Junte-se a mais de 3000 membros da <span class="shop-green">AB Store</span></p><br>
					</div>
					
					
					<div class="col-md-6">
						<form id="sky-form4" class="log-reg-block sky-form" method="post" action="ClienteController">
							<h2>Criar nova conta</h2>

							<div class="login-input reg-input">
							
								<input type="hidden" name="acao" value="gravarCliente" >
								
										<section>
											<label class="input">
												<input type="text" name="nomeCliente" placeholder="Nome completo" class="form-control">
											</label>
										</section>						
							
								
								<section>
									<label class="input">
										<input type="email" name="emailCliente" placeholder="Email" class="form-control">
									</label>
								</section>
								<section>
									<label class="input">
										<input type="password" name="senhaCliente" placeholder="Senha" id="password" class="form-control">
									</label>
								</section>
								<section>
									<label class="input">
										<input type="password" name="passwordConfirm" placeholder="Confirmar senha" class="form-control">
									</label>
								</section>
							</div>

				
							<label class="checkbox margin-bottom-20">
								<input type="checkbox" name="checkbox"/>
								<i></i>
								Eu concordo com os <a href="#">termos &amp; condições</a> da Adventure Books
							</label>
							<button class="btn-u btn-u-sea-shop btn-block margin-bottom-20" type="submit">Create Account</button>
						</form>

						<div class="margin-bottom-20"></div>
						<p class="text-center">Já se cadastrou? <a href="shop-ui-login.jsp">Logue aqui</a></p>
					</div>
				</div><!--/end row-->
			</div><!--/end container-->
		</div>
		<!--=== End Registre ===-->

		

 <!--=== Footer v4 ===-->
    <div class="footer-v4">
        <div class="footer">
            <div class="container">
                <div class="row">
                    <!-- About -->
                    <div class="col-md-12 md-margin-bottom-40">
                        <div class="col-md-6"><a href="index.jsp"><img class="footer-logo" src="assets/img/logo-2.png" alt=""></a></div>
                        <div class="col-md-6"><p>Siga nossas redes sociais para informações diretas sobre o nosso Universo.</p>
                        <br>
                        <ul class="list-unstyled address-list margin-bottom-20">
                            <li><i class="fa fa-angle-right"></i>Avenida do Contorno - 3669 - Belo Horizonte, MG</li>
                            <li><i class="fa fa-angle-right"></i>Telefone: (31) 3588-8548</li>
                            <li><i class="fa fa-angle-right"></i>Email: contato@adventure-books.com</li>
                        </ul>

                        <ul class="list-inline shop-social">
                            <li><a href="#"><i class="fb rounded-md fa fa-facebook"></i></a></li>
                            <li><a href="#"><i class="tw rounded-md fa fa-twitter"></i></a></li>
                            <li><a href="#"><i class="gp rounded-md fa fa-google-plus"></i></a></li>
                        </ul>
						</div>
                    </div>
                    <!-- End About -->                    
                </div><!--/end row-->
            </div><!--/end continer-->
        </div><!--/footer-->

        <div class="copyright">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">                     
                        <p>
                            2016 &copy; Team Adventure. ALL Rights Reserved. 
                            <a target="_blank" href="https://twitter.com/htmlstream">Team Adventure</a> | <a href="#">Privacy Policy</a> | <a href="#">Terms of Service</a>
                        </p>
                    </div>
                    <div class="col-md-6">  
                        <ul class="list-inline sponsors-icons pull-right">
                            <li><i class="fa fa-cc-paypal"></i></li>
                            <li><i class="fa fa-cc-visa"></i></li>
                            <li><i class="fa fa-cc-mastercard"></i></li>
                            <li><i class="fa fa-cc-discover"></i></li>
                        </ul>
                    </div>
                </div>
            </div> 
        </div><!--/copyright--> 
    </div>
    <!--=== End Footer v4 ===-->
	</div><!--/wrapper-->

	<!-- JS Global Compulsory -->
	<script src="assets/plugins/jquery/jquery.min.js"></script>
	<script src="assets/plugins/jquery/jquery-migrate.min.js"></script>
	<script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
	<!-- JS Implementing Plugins -->
	<script src="assets/plugins/back-to-top.js"></script>
	<script src="assets/plugins/smoothScroll.js"></script>
	<script src="assets/plugins/sky-forms-pro/skyforms/js/jquery.validate.min.js"></script>
	<script src="assets/plugins/scrollbar/js/jquery.mCustomScrollbar.concat.min.js"></script>
	<!-- JS Customization -->
	<script src="assets/js/custom.js"></script>
	<!-- JS Page Level -->
	<script src="assets/js/shop.app.js"></script>
	<script src="assets/js/plugins/style-switcher.js"></script>
	<script src="assets/js/forms/page_registration.js"></script>
	<script>
		jQuery(document).ready(function() {
			App.init();
			App.initScrollBar();
			Registration.initRegistration();
			StyleSwitcher.initStyleSwitcher();
		});
	</script>

<!--[if lt IE 9]>
	<script src="assets/plugins/respond.js"></script>
	<script src="assets/plugins/html5shiv.js"></script>
	<script src="assets/js/plugins/placeholder-IE-fixes.js"></script>
	<script src="assets/plugins/sky-forms-pro/skyforms/js/sky-forms-ie8.js"></script>
	<![endif]-->
<!--[if lt IE 10]>
	<script src="assets/plugins/sky-forms-pro/skyforms/js/jquery.placeholder.min.js"></script>
	<![endif]-->

</body>
</html>

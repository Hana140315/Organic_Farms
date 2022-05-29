<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Foody - Organic Food Website Template</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;500&family=Lora:wght@600;700&display=swap" rel="stylesheet"> 

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Spinner Start -->
    <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
        <div class="spinner-border text-primary" role="status"></div>
    </div>
    <!-- Spinner End -->


    <!-- Navbar Start -->
 

    <nav class="navbar navbar-expand-lg navbar-light py-lg-0 px-lg-5 wow fadeIn" data-wow-delay="0.1s">
        <a href="/" class="navbar-brand ms-4 ms-lg-0">
            <h1 class="fw-bold text-primary m-0">Bio <span class="text-secondary">Palestine</span></h1>
        </a>
        <button type="button" class="navbar-toggler me-4" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <div class="navbar-nav ms-auto p-4 p-lg-0">
                
                <a href="/" class="nav-item nav-link">Home</a>
                <a href="/product" class="nav-item nav-link">Products</a>
                <a href="/about" class="nav-item nav-link">About Us</a>
                <a href="/contactUs" class="nav-item nav-link">Contact Us</a>
                <a href="/login" class="nav-item nav-link"><span class="fw-bold text-secondary">Login</span></a>
                <a href="/register" class="nav-item nav-link"><span class="fw-bold text-primary m-0">Register</span></a>
            </div>
            
        </div>
    </nav>
</div>
<!-- Navbar End -->


    <!-- Carousel Start -->
    <div class="container-fluid p-0 mb-5 wow fadeIn" data-wow-delay="0.1s">
        <div id="header-carousel" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    
                    <img class="w-100" src="img/carousel-1.jpg" alt="Image">
                    
                    <div class="carousel-caption">
                        <div class="container">
                            <div class="row justify-content-start">
                                <div class="col-lg-7">
                                    <h1 class="display-2 mb-5 animated slideInDown">Organic Food Is Good For Health</h1>
                                    <a href="/product" class="btn btn-primary rounded-pill py-sm-3 px-sm-5">Products</a>
                                    <a href="https://api.spoonacular.com/food/ingredients/search" class="btn btn-secondary rounded-pill py-sm-3 px-sm-5 ms-3">Sources</a>
                                  
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="carousel-item">
                    <img class="w-100" src="img/carousel-2.jpg" alt="Image">
                    <div class="carousel-caption">
                        <div class="container">
                            <div class="row justify-content-start">
                                <div class="col-lg-7">
                                    <h1 class="display-2 mb-5 animated slideInDown">Natural Food Is Always Healthy</h1>
                                    <a href="/product" class="btn btn-primary rounded-pill py-sm-3 px-sm-5">Products</a>
                                    <a href="https://api.spoonacular.com/food/ingredients/search" class="btn btn-secondary rounded-pill py-sm-3 px-sm-5 ms-3">Sources</a>
                                   
				                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#header-carousel"
                data-bs-slide="prev">
                
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
        </div>
    </div>
    <!-- Carousel End -->


    <!-- About Start -->
    <div class="container-xxl py-5">
        <div class="container">
            <div class="row g-5 align-items-center">
                <div class="col-lg-6 wow fadeIn" data-wow-delay="0.1s">
                    <div class="about-img position-relative overflow-hidden p-5 pe-0">
                        <img class="img-fluid w-100" src="img/about.jpg">
                    </div>
                </div>
                <div class="col-lg-6 wow fadeIn" data-wow-delay="0.5s">
                    <h1 class="display-5 mb-4">What is organic food?</h1>
                    <p class="mb-4">Organic food is produced by farmers who avoid the use of bio-persistent nonselective chemical pesticides, fungicides and fertilizers. Farmers emphasize the use of renewable (or sustainable) resources and the conservation of soil and water to enhance environmental quality for future generations.</p>
                    <h1 class="display-5 mb-4">Does natural mean organic?</h1>
                    <p class="mb-4">Organic foods are grown without artificial pesticides, fertilizers, or herbicides. Organic meat, eggs, and dairy products are obtained from animals that are fed natural feed and not given hormones or antibiotics. Natural foods are free of synthetic or artificial ingredients or additives.</p>
                    
                    <h1 class="display-5 mb-4">Best Organic Fruits And Vegetables</h1>
                    <p class="mb-4">grown without using most conventional pesticides, fertilizers made with synthetic ingredients or sewage sludge; bioengineer seed or plants; or ionizing radiation.</p>
                    
                </div>
            </div>
        </div>
    </div>
    <!-- About End -->


    <!-- Feature Start -->
    <div class="container-fluid bg-light bg-icon my-5 py-6">
        <div class="container">
            <div class="section-header text-center mx-auto mb-5 wow fadeInUp" data-wow-delay="0.1s" style="max-width: 500px;">
                <h1 class="display-5 mb-3">Our Features</h1>
                <p>This programme focused on improving food security and incomes of small scale farmers. The programme emphasised sustainable farming practices.</p>
            </div>
            <div class="row g-4">
                <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
                    <div class="bg-white text-center h-100 p-4 p-xl-5">
                        <img class="img-fluid mb-4" src="img/icon-1.png" alt="">
                        <h4 class="mb-3">Natural Process</h4>
                        <p class="mb-4">Natural processes are interactions among plants, animals, and the environment. These interactions, which include photosynthesis , pollination, decomposition , and others, help create and shape natural communities.</p>
                       
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
                    <div class="bg-white text-center h-100 p-4 p-xl-5">
                        <img class="img-fluid mb-4" src="img/icon-2.png" alt="">
                        <h4 class="mb-3">Organic Products</h4>
                        <p class="mb-4">Organic food products are grown under a system of agriculture without the use of harmful chemical fertilizers and pesticides with an environmentally and socially responsible approach.</p>
                       
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
                    <div class="bg-white text-center h-100 p-4 p-xl-5">
                        <img class="img-fluid mb-4" src="img/icon-3.png" alt="">
                        <h4 class="mb-3">Biologically Safe</h4>
                        <p class="mb-4">The supply of safe food begins with a good understanding of hygiene requirement during the processing and packaging of food products.</p>
                       
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Feature End -->


    <!-- Product Start -->
    <div class="col-lg-6 text-start text-lg-end wow slideInRight" data-wow-delay="0.1s">
                    <ul class="nav nav-pills d-inline-flex justify-content-end mb-5">
                    <c:forEach var="category" items="${category}">
                        <li class="nav-item me-2">
                            <a class="btn btn-outline-primary border-2 active" data-bs-toggle="pill" href="">${category.categoryTitle}</a>
                        </li>
                      </c:forEach>
                       
                    </ul>
                </div>
    <div class="container-xxl py-5">
        <div class="container">
            <div class="row g-0 gx-5 align-items-end">
                <div class="col-lg-6">
                    <div class="section-header text-start mb-5 wow fadeInUp" data-wow-delay="0.1s" style="max-width: 500px;">
                        <h1 class="display-5 mb-3">Our Products</h1>
                
                    </div>
                </div>
        
            </div>
               
            <div class="tab-content">
                <div id="tab-1" class="tab-pane fade show p-0 active">
                   
		       <div class="row g-4">
                       
                        <div class="col-xl-3 col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.2s">
							<c:forEach var="products" items="${product}">
                            <div class="product-item">
                             
                                <div class="position-relative bg-light overflow-hidden">
                                    <img class="img-fluid w-100" src="img/product-1.jpg" alt="">
                                </div>
                                <div class="text-center p-4">
                                    <a class="d-block h5 mb-2 " href="/detail/${products.id}"><i class="fa fa-eye text-primary me-2"></i>${products.productName }</a>
                                    <span class="text-primary me-1"> ${products.productPrice}$/Kilo</span>
                                </div>
                                
                            </div>
                          </c:forEach>
                        </div>
                        </div>
		     
                </div>
            </div>
              
        </div>
    </div>
    <!-- Product End -->



    <!-- Firm Visit Start -->
    <div class="container-fluid bg-primary bg-icon mt-5 py-6">
        <div class="container">
            <div class="row g-5 align-items-center">
                <div class="col-md-7 wow fadeIn" data-wow-delay="0.1s">
                    <h1 class="display-5 text-white mb-3">Visit Our Firm</h1>
                    <p class="text-white mb-0">Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit. Aliqu diam amet diam et eos. Clita erat ipsum et lorem et sit, sed stet lorem sit clita duo justo magna dolore erat amet. Diam dolor diam ipsum sit. Aliqu diam amet diam et eos.</p>
                </div>
                <div class="col-md-5 text-md-end wow fadeIn" data-wow-delay="0.5s">
                    <a class="btn btn-lg btn-secondary rounded-pill py-3 px-5" href="">Visit Now</a>
                </div>
            </div>
        </div>
    </div>
    <!-- Firm Visit End -->


    <!-- Testimonial Start -->
    <div class="container-fluid bg-light bg-icon py-6 mb-5">
        <div class="container">
            <div class="section-header text-center mx-auto mb-5 wow fadeInUp" data-wow-delay="0.1s" style="max-width: 500px;">
                <h1 class="display-5 mb-3">Customer Review</h1>
                <p>Tempor ut dolore lorem kasd vero ipsum sit eirmod sit. Ipsum diam justo sed rebum vero dolor duo.</p>
            </div>
            <div class="owl-carousel testimonial-carousel wow fadeInUp" data-wow-delay="0.1s">
                <div class="testimonial-item position-relative bg-white p-5 mt-4">
                    <i class="fa fa-quote-left fa-3x text-primary position-absolute top-0 start-0 mt-n4 ms-5"></i>
                    <p class="mb-4">Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit diam amet diam et eos. Clita erat ipsum et lorem et sit.</p>
                    <div class="d-flex align-items-center">
                        <img class="flex-shrink-0 rounded-circle" src="img/testimonial-1.jpg" alt="">
                        <div class="ms-3">
                            <h5 class="mb-1">Client Name</h5>
                            <span>Profession</span>
                        </div>
                    </div>
                </div>
                <div class="testimonial-item position-relative bg-white p-5 mt-4">
                    <i class="fa fa-quote-left fa-3x text-primary position-absolute top-0 start-0 mt-n4 ms-5"></i>
                    <p class="mb-4">Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit diam amet diam et eos. Clita erat ipsum et lorem et sit.</p>
                    <div class="d-flex align-items-center">
                        <img class="flex-shrink-0 rounded-circle" src="img/testimonial-2.jpg" alt="">
                        <div class="ms-3">
                            <h5 class="mb-1">Client Name</h5>
                            <span>Profession</span>
                        </div>
                    </div>
                </div>
                <div class="testimonial-item position-relative bg-white p-5 mt-4">
                    <i class="fa fa-quote-left fa-3x text-primary position-absolute top-0 start-0 mt-n4 ms-5"></i>
                    <p class="mb-4">Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit diam amet diam et eos. Clita erat ipsum et lorem et sit.</p>
                    <div class="d-flex align-items-center">
                        <img class="flex-shrink-0 rounded-circle" src="img/testimonial-3.jpg" alt="">
                        <div class="ms-3">
                            <h5 class="mb-1">Client Name</h5>
                            <span>Profession</span>
                        </div>
                    </div>
                </div>
                <div class="testimonial-item position-relative bg-white p-5 mt-4">
                    <i class="fa fa-quote-left fa-3x text-primary position-absolute top-0 start-0 mt-n4 ms-5"></i>
                    <p class="mb-4">Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit diam amet diam et eos. Clita erat ipsum et lorem et sit.</p>
                    <div class="d-flex align-items-center">
                        <img class="flex-shrink-0 rounded-circle" src="img/testimonial-4.jpg" alt="">
                        <div class="ms-3">
                            <h5 class="mb-1">Client Name</h5>
                            <span>Profession</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Testimonial End -->


  



    <!-- Footer Start -->
    <div class="container-fluid bg-dark footer pt-5 wow fadeIn" data-wow-delay="0.1s">
        <div class="container py-5">
            <div class="row g-5">
                <div class="col-lg-3 col-md-6">
                    <h1 class="fw-bold text-primary mb-4">Bio <span class="text-secondary">Palestine</span></h1>
                    <p>Full Stack Java Developer</p>
                    <div class="d-flex pt-2">
                        <a class="btn btn-square btn-outline-light rounded-circle me-1" href=""><i class="fab fa-twitter"></i></a>
                        <a class="btn btn-square btn-outline-light rounded-circle me-1" href=""><i class="fab fa-facebook-f"></i></a>
                        <a class="btn btn-square btn-outline-light rounded-circle me-1" href=""><i class="fab fa-youtube"></i></a>
                        <a class="btn btn-square btn-outline-light rounded-circle me-0" href=""><i class="fab fa-linkedin-in"></i></a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <h4 class="text-light mb-4">Address</h4>
                    <p><i class="fa fa-map-marker-alt me-3"></i> Ramalla,Palestine</p>
                    <p><i class="fa fa-phone-alt me-3"></i>+9720595045885</p>
                    <p><i class="fa fa-envelope me-3"></i>Majedamrya@hotmail.com</p>
                </div>
                <div class="col-lg-3 col-md-6">
                    <h4 class="text-light mb-4">Quick Links</h4>
                    <a class="btn btn-link" href="">About Us</a>
                    <a class="btn btn-link" href="">Contact Us</a>
                    <a class="btn btn-link" href="">Team Member</a>
                </div>
    
        <div class="container-fluid copyright">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
                        &copy; <a href="#">Bio Palestine</a>, All Right Reserved.
                    </div>
                    
                </div>
            </div>
        </div>
    </div>
    <!-- Footer End -->


    <!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary btn-lg-square rounded-circle back-to-top"><i class="bi bi-arrow-up"></i></a>


    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="lib/wow/wow.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
</body>

</html>
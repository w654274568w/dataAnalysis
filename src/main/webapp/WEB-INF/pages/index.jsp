<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<!DOCTYPE html>
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" /> <!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Graph CSS -->
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- jQuery -->

<!-- lined-icons -->
<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />
<link href="css/barChart.css" rel='stylesheet' type='text/css' />
<link href="css/fabochart.css" rel='stylesheet' type='text/css' />

<!--clock init-->
<script src="js/css3clock.js"></script>
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<!--//skycons-icons-->
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>数据分析</title>
</head>
<body>
	<div class="page-container">
		<div class="left-content">
			<div class="sidebar-menu">
				<header class="logo">
					<a>
						<span id="logo"> 
							<h1 style="">
							房产数据
							</h1>
						</span> 
					</a> 
				</header>
				<div class="menu">
				</div>
			</div>
			<div class="left-content">
				<div class="inner-content">
					<div class="header-section" heigth="2000">
						<div class="header-section" higth="2000px">
						</div>
					</div>
					<div class="outter-wp">
						<div class="custom-widgets">
							<div class="row-one">
								<div class="col-md-3 widget">
									<div class="stats-left">
										<h5>历史数据量</h5>
										<h4>${historyCount }条</h4>
									</div>
									<div class="clearfix"> </div>	
								</div>
								<div class="col-md-3 widget states-mdl">
									<div class="stats-left">
										<h5>本周数据量</h5>
										<h4>${thisWeekCount }条</h4>
										
									</div>
								</div>
								<div class="col-md-3 widget states-thrd">
									<div class="stats-left">
										<h5>本周总价均价</h5>
										<h4>${thisWeekAverageTotalPrice }万元</h4>
									</div>
									<div class="stats-right">
										<label style="color:red">${averagePriceRate }%</label>
									</div>
								</div>
								<div class="col-md-3 widget states-last">
									<div class="stats-left">
										<h5>本周单价均价</h5>
										<h4>${thisWeekAveragePrice }元</h4>
									</div>
									<div class="stats-right">
										<label style="color:red">${totalPriceRate }%</label>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">

</script>

</html>
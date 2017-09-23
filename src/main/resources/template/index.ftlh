<html>
	<head>
		<title>${title}</title>
		<link rel="stylesheet" href="style/styles.css">
	</head>

	<body>
		<h1>${title}</h1>
		<#list sections as section>
			<h3>Section : ${section.title}</h3>
			<#list section.stories as story>
				<#include "story.ftlh">
			</#list>
		</#list>
	</body>
</html>
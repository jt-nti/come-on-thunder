.version.name=$version | if $tag != "none" then .version.vcs_tag=$tag else . end | .version.desc |= . + " " + $commit | .version.released=(now|todate)
SUMMARY = "Simple Hello Custom app"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"

SRC_URI = "git://github.com/toncompte/hellocustom.git;protocol=https;branch=main"
SRCREV = "AUTOINC"

S = "${WORKDIR}/git/src"

do_compile() {
    oe_runmake CC="${CC}" CFLAGS="${CFLAGS}" LDFLAGS="${LDFLAGS}"
}

do_install() {
    oe_runmake install DESTDIR=${D}
}

FILES_${PN} = "/usr/bin/hellocustom"

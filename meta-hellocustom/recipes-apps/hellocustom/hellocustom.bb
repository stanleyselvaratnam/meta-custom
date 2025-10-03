SUMMARY = "Simple Hello Custom app"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3914388ed65427d749c0c5886d2d12cf"

SRC_URI = "file://main.c"
S = "${WORKDIR}"

do_compile() {
    oe_runmake CC="${CC}" CFLAGS="${CFLAGS}" LDFLAGS="${LDFLAGS}"
}

do_install() {
    oe_runmake install DESTDIR=${D}
}

FILES_${PN} = "/usr/bin/hellocustom"

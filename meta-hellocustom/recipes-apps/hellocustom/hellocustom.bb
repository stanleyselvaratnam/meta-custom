SUMMARY = "Simple Hello Custom app"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = "file://main.c"

S = "${WORKDIR}"

do_compile() {
    oe_runmake CC="${CC}" CFLAGS="${CFLAGS}" LDFLAGS="${LDFLAGS}"
}

do_install() {
    oe_runmake install DESTDIR=${D}
}

FILES_${PN} = "/usr/bin/hellocustom"

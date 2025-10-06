SUMMARY = "Install Mender artifact verification key"
LICENSE = "CLOSED"
SRC_URI = "file://public.key"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/mender
    install -m 0644 public.key ${D}${sysconfdir}/mender/public.key
}

FILES_${PN} += "${sysconfdir}/mender/public.key"
